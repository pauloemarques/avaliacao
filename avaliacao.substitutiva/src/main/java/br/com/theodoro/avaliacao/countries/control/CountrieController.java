package br.com.theodoro.avaliacao.countries.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.theodoro.avaliacao.countries.model.Countries;
import br.com.theodoro.avaliacao.countries.service.CountrieService;
@RestController
@RequestMapping("/countrie")
public class CountrieController {

	@Autowired
	private CountrieService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public void salvar(@RequestBody Countries countries) {
		service.save(countries);
	}

	@RequestMapping(value = "/deletar/{idCountries}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("idCountries") Long id) {
		service.delete(id);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Countries>> listarTodos() {
		return new ResponseEntity<List<Countries>>(service.findAll(), HttpStatus.OK);
	}
}
