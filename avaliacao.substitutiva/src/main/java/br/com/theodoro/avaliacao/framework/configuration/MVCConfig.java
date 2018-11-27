package br.com.theodoro.avaliacao.framework.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.com.theodoro.avaliacao.acesso.control",
		"br.com.theodoro.avaliacao.social.media.control", "br.com.theodoro.avaliacao.address.control",
		"br.com.theodoro.avaliacao.cities.control", "br.com.theodoro.avaliacao.countries.control",
		"br.com.theodoro.avaliacao.states.control" })
public class MVCConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);

		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setBasename("spring/report-views");

		registry.viewResolver(viewResolver);

		InternalResourceViewResolver iViewResolver = new InternalResourceViewResolver();

		registry.viewResolver(iViewResolver);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("csv", new MediaType("text", "csv")).favorParameter(true).parameterName("format");
		super.configureContentNegotiation(configurer);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new MappingJackson2XmlHttpMessageConverter());
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
}