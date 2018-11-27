package br.com.theodoro.avaliacao.framework.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.theodoro.avaliacao.acesso.service",
		"br.com.theodoro.avaliacao.social.media.service",
		"br.com.theodoro.avaliacao.address.service",
		"br.com.theodoro.avaliacao.cities.service",
		"br.com.theodoro.avaliacao.countries.service",
		"br.com.theodoro.avaliacao.states.service"

})
public class FrameworkConfig {

}