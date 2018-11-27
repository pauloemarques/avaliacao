package br.com.theodoro.avaliacao.cities.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CitiesRepository extends CrudRepository<Cities, Long>, JpaSpecificationExecutor<Cities>{

}
