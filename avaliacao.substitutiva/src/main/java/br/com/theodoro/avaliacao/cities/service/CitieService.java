package br.com.theodoro.avaliacao.cities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.cities.model.Cities;
import br.com.theodoro.avaliacao.cities.model.CitiesRepository;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;

@Service
public class CitieService {

	@Autowired
	private CitiesRepository repository;

	public void save(Cities cities) {
		repository.save(cities);
	}

	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("ID da cidade não encontrado.");
		}
		repository.delete(id);
	}

	public List<Cities> findAll() {
		Specification<Cities> spec = null;
		return repository.findAll(spec);
	}
}
