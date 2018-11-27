package br.com.theodoro.avaliacao.acesso.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User {

	@Column(name = "user_id")
	private String id;
	@Column(name = "phone_number")
	private String numeroTelefone;
	@Column(name = "email")
	private String email;
	@Column(name = "first_name")
	private String nome;
	@Column(name = "last_name")
	private String sobrenome;
	@Column(name = "date_of_birth")
	private String aniversario;
	@Column(name = "national_id")
	private String nacionalidade;
	@Column(name = "phone_validated")
	private boolean telefoneValido;
	@Column(name = "email_confirmed")
	private boolean emailValido;
	@Column(name = "create_time")
	private LocalDateTime dataCriacao;
	@Column(name = "password_enc")
	private String senhaCriptografada;
	@Column(name = "password_salt")
	private String senha;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public boolean isTelefoneValido() {
		return telefoneValido;
	}

	public void setTelefoneValido(boolean telefoneValido) {
		this.telefoneValido = telefoneValido;
	}

	public boolean isEmailValido() {
		return emailValido;
	}

	public void setEmailValido(boolean emailValido) {
		this.emailValido = emailValido;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSenhaCriptografada() {
		return senhaCriptografada;
	}

	public void setSenhaCriptografada(String senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
