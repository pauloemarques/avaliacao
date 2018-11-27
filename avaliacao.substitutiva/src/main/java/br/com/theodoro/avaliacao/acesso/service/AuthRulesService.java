package br.com.theodoro.avaliacao.acesso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.acesso.model.User;


@Service
public class AuthRulesService {
	
	@Autowired
	private AuthService authService;


	public User getCurrentUser(){
		return authService.getCurrent();
	}
}
