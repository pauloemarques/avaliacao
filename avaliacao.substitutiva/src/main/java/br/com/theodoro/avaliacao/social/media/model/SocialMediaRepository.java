package br.com.theodoro.avaliacao.social.media.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.theodoro.avaliacao.acesso.model.User;

public interface SocialMediaRepository extends CrudRepository<SocialMedia, Long>, JpaSpecificationExecutor<SocialMedia>{

	List<SocialMedia> findByUser(User user);
}
