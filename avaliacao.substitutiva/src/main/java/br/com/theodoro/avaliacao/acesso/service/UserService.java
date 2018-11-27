package br.com.theodoro.avaliacao.acesso.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.acesso.model.UserRepository;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void save(User user) {
		User usuario = repository.findOne(user.getId());
		if (usuario == null) {
			user.setDataCriacao(LocalDateTime.now());
		}
		repository.save(user);
	}

	public void delete(String id) {
		if (id == null) {
			throw new BusinessException("ID do Usuário nulo.");
		}
		repository.delete(id);
	}

	public List<User> findAll() {
		Specification<User> spec = Specifications.where(null);
		Pageable page = new PageRequest(0, 1000,
				new Sort(new Sort.Order(Direction.ASC, "nome"), new Sort.Order(Direction.ASC, "id")));
		return repository.findAll(spec, page).getContent();
	}

	public User buildUser(String id) {
		User user = null;
		if (id != null) {
			user = repository.findOne(id);
		}
		return user;
	}
}
