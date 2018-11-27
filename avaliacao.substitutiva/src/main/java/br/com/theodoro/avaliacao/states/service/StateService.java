package br.com.theodoro.avaliacao.states.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.framework.exception.BusinessException;
import br.com.theodoro.avaliacao.states.model.States;
import br.com.theodoro.avaliacao.states.model.StatesRepository;

@Service
public class StateService {

	@Autowired
	private StatesRepository repository;

	public void save(States states) {
		repository.save(states);
	}

	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("ID do estado não encontrado.");
		}
		repository.delete(id);
	}

	public List<States> findAll() {
		Specification<States> spec = null;
		return repository.findAll(spec);
	}
}
