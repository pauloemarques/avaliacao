package br.com.theodoro.avaliacao.acesso.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>, JpaSpecificationExecutor<User> {

	User findByEmail(String email);
}
