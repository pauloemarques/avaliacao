package br.com.theodoro.avaliacao.cities.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.theodoro.avaliacao.framework.model.BaseEntity;
import br.com.theodoro.avaliacao.states.model.States;

@Entity
@Table(name = "cities", schema = "public")
public class Cities extends BaseEntity {

	@Column(name = "city_name")
	private String nome;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private States estados;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public States getEstados() {
		return estados;
	}

	public void setEstados(States estados) {
		this.estados = estados;
	}

}
