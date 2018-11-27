package br.com.theodoro.avaliacao.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.theodoro.avaliacao.countries.model.Countries;
import br.com.theodoro.avaliacao.countries.model.CountriesRepository;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;

@Service
public class CountrieService {

	@Autowired
	private CountriesRepository repository;

	public void save(Countries country) {
		repository.save(country);
	}

	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("ID da cidade não encontrada.");
		}
		repository.delete(id);
	}

	public List<Countries> findAll() {
		Specification<Countries> spec = null;
		return repository.findAll(spec);
	}
}
