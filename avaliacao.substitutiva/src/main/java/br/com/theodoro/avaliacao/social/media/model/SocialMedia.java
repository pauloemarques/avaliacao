package br.com.theodoro.avaliacao.social.media.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.framework.model.BaseEntity;

@Entity
@Table(name = "social_media", schema = "public")
public class SocialMedia extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User usuario;
	@Column(name = "social_profile_id")
	private String perfil;
	@Column(name = "social_provider")
	private String provedor;
	@Column(name = "authenticate")
	private boolean autenticado;

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getProvedor() {
		return provedor;
	}

	public void setProvedor(String provedor) {
		this.provedor = provedor;
	}

	public boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

}
