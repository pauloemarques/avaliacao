package br.com.theodoro.avaliacao.states.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.theodoro.avaliacao.countries.model.Countries;
import br.com.theodoro.avaliacao.framework.model.BaseEntity;

@Entity
@Table(name = "states", schema = "public")
public class States extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "country_code")
	private Countries pais;
	@Column(name = "state_name")
	private String nome;

	public Countries getPais() {
		return pais;
	}

	public void setPais(Countries pais) {
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
