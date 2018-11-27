package br.com.theodoro.avaliacao.framework.configuration;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import br.com.theodoro.avaliacao.acesso.service.AuthService;
import br.com.theodoro.avaliacao.util.GetPropertyUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthService authService;
	
	private static final String urlCasPushHost = "br.gov.sp.tce.dti.nemesis.pauta.cas.push-host";
	
	/**
	 * 
	 * Method - serviceProperties
	 * Return - ServiceProperties
	 * @return
	 *
	 */
	@Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(GetPropertyUtils.getProperty(urlCasPushHost) + "/j_spring_cas_security_check");
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

	@Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        casAuthenticationProvider.setAuthenticationUserDetailsService(authService);
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only");
        return casAuthenticationProvider;
    }
	

    @Bean
    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
    	Cas20ServiceTicketValidator cas20ServiceTicketValidator  = new Cas20ServiceTicketValidator(GetPropertyUtils.getProperty(urlCasPushHost));
   
    	return cas20ServiceTicketValidator;
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
        casAuthenticationFilter.setSessionAuthenticationStrategy(sessionStrategy());
        casAuthenticationFilter.setFilterProcessesUrl("/j_spring_cas_security_check");
        return casAuthenticationFilter;
    }

    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(GetPropertyUtils.getProperty(urlCasPushHost) + "/login");
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }
    
    @Bean
    @Order
    public SingleSignOutFilter singleLogoutFilter() {
        return new SingleSignOutFilter();
    }

    @Bean
    public LogoutFilter requestSingleLogoutFilter() {
    	LogoutFilter filter = new LogoutFilter(GetPropertyUtils.getProperty(urlCasPushHost) + "/logout", new SecurityContextLogoutHandler());
    	
    	return filter;
    }

    @Bean
    public SessionAuthenticationStrategy sessionStrategy() {
        SessionFixationProtectionStrategy sessionStrategy = new SessionFixationProtectionStrategy();
        sessionStrategy.setMigrateSessionAttributes(false);
        return sessionStrategy;
    }

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(casAuthenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .addFilterBefore(casAuthenticationFilter(), BasicAuthenticationFilter.class)
        .addFilterBefore(requestSingleLogoutFilter(), LogoutFilter.class)
        .addFilterBefore(singleLogoutFilter(), CasAuthenticationFilter.class)
  
        //.addFilterBefore(corsFilter, CasAuthenticationFilter.class)
        .exceptionHandling()
            .authenticationEntryPoint(casAuthenticationEntryPoint())
        .and()
        .csrf().disable()
        .authorizeRequests()
		.antMatchers("/v1.0/P/**").permitAll()
		.antMatchers("/v1.0/**").authenticated()
//		.antMatchers("/v1.0/**").permitAll() 
//		.anyRequest().permitAll()
		.and()
		.logout().logoutSuccessUrl(GetPropertyUtils.getProperty(urlCasPushHost) + "/login");
		
	}
}
