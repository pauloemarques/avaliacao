package br.com.theodoro.avaliacao.countries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.theodoro.avaliacao.framework.model.BaseEntity;

@Entity
@Table(name = "countries", schema = "public")
public class Countries extends BaseEntity {

	@Column(name = "country_code")
	private String pais;
	@Column(name = "country_name_br")
	private String nomeBR;
	@Column(name = "country_name_en")
	private String nomeEN;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNomeBR() {
		return nomeBR;
	}

	public void setNomeBR(String nomeBR) {
		this.nomeBR = nomeBR;
	}

	public String getNomeEN() {
		return nomeEN;
	}

	public void setNomeEN(String nomeEN) {
		this.nomeEN = nomeEN;
	}

}
