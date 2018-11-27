package br.com.theodoro.avaliacao.framework.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AvaliacaoAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{JPAConfig.class, FrameworkConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MVCConfig	.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/v1.0/*"};
	}

}
