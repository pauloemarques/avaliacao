package br.com.theodoro.avaliacao.acesso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.acesso.model.AuthUser;
import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.acesso.model.UserRepository;

@Service
public class AuthService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

	@Autowired
	private UserRepository userRepository;

	public User getCurrent() {
		AuthUser userAuth = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (userAuth.getUsuario() == null) {
			throw new AuthenticationServiceException("Não autorizado, email inválido");
		}

		return userAuth.getUsuario();
	}

	@Override
	public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
		String email = token.getPrincipal().toString();

		User usuario = userRepository.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException("Não encontrado no sistema");
		}

		return new AuthUser(usuario);
	}

}
