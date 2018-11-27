package br.com.theodoro.avaliacao.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.cities.model.Cities;
import br.com.theodoro.avaliacao.framework.model.BaseEntity;

@Entity
@Table(name = "address", schema = "public")
public class Address extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User usuario;
	@Column(name = "street_name")
	private String rua;
	@Column(name = "number")
	private String numero;
	@Column(name = "complement")
	private String complemento;
	@Column(name = "neighborhood")
	private String vizinho;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private Cities cidade;
	@Column(name = "postal_code")
	private String cep;
	@Column(name = "address_name")
	private String endereco;
 
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getVizinho() {
		return vizinho;
	}

	public void setVizinho(String vizinho) {
		this.vizinho = vizinho;
	}

	public Cities getCidade() {
		return cidade;
	}

	public void setCidade(Cities cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
