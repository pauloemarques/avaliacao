package br.com.theodoro.avaliacao.framework.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "br.com.theodoro.avaliacao.acesso.model",
		"br.com.theodoro.avaliacao.social.media.model", "br.com.theodoro.avaliacao.address.model",
		"br.com.theodoro.avaliacao.cities.model", "br.com.theodoro.avaliacao.countries.model",
		"br.com.theodoro.avaliacao.states.model" })
@PropertySource(value = { "classpath:application.properties" })
public class JPAConfig {
	@Autowired
	private Environment environment;

	private DataSource ds = null;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(
				new String[] { "br.com.theodoro.avaliacao.acesso.model", "br.com.theodoro.avaliacao.social.media.model",
						"br.com.theodoro.avaliacao.address.model", "br.com.theodoro.avaliacao.cities.model",
						"br.com.theodoro.avaliacao.countries.model", "br.com.theodoro.avaliacao.states.model" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {
		try {
			Context initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup(environment.getRequiredProperty("jdbc.jndi"));
			initCtx.close();

			return ds;

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		if (environment.containsProperty("hibernate.hbm2ddl.auto")) {
			properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		}
		properties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql", "true"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql", "true"));
		properties.setProperty("hibernate.generate_statistics",
				environment.getProperty("hibernate.generate_statistics", "false"));
		return properties;
	}
}