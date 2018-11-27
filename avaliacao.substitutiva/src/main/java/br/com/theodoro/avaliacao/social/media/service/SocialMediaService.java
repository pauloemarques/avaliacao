package br.com.theodoro.avaliacao.social.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.acesso.service.AuthService;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;
import br.com.theodoro.avaliacao.social.media.model.SocialMedia;
import br.com.theodoro.avaliacao.social.media.model.SocialMediaRepository;

@Service
public class SocialMediaService {

	@Autowired
	private SocialMediaRepository repository;

	@Autowired
	private AuthService authService;

	public void save(SocialMedia socialMedia) {
		socialMedia.setUsuario(authService.getCurrent());
		repository.save(socialMedia);
	}

	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("Rede Social não encontrada.");
		}
		repository.delete(id);
	}

	public List<SocialMedia> findByUser() {
		return repository.findByUser(authService.getCurrent());
	}

	public List<SocialMedia> findAll() {
		Specification<SocialMedia> spec = null;
		return repository.findAll(spec);
	}
}
