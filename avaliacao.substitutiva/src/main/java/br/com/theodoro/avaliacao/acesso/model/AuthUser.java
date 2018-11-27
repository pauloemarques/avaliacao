package br.com.theodoro.avaliacao.acesso.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUser implements UserDetails {

	private static final long serialVersionUID = -8767063973085567869L;
	private User usuario;

	public AuthUser(User usuario) {
		this.usuario = usuario;
	}

	public User getUsuario() {
		return this.usuario;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

}
