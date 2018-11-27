package br.com.theodoro.avaliacao.states.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StatesRepository extends CrudRepository<States, Long>, JpaSpecificationExecutor<States> {

}
