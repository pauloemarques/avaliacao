package br.com.theodoro.avaliacao.countries.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Countries, Long>, JpaSpecificationExecutor<Countries> {

}
