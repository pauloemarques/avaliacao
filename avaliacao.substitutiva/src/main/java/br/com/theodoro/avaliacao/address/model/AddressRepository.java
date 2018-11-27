package br.com.theodoro.avaliacao.address.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>, JpaSpecificationExecutor<Address> {

}
