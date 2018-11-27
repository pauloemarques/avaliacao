package br.com.theodoro.avaliacao.cities.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.theodoro.avaliacao.cities.model.Cities;
import br.com.theodoro.avaliacao.cities.service.CitieService;

@RestController
@RequestMapping("/cities")
public class CitieController {

	@Autowired
	private CitieService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public void salvar(@RequestBody Cities cities) {
		service.save(cities);
	}

	@RequestMapping(value = "/deletar/{idCities}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("idCities") Long id) {
		service.delete(id);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Cities>> listarTodos() {
		return new ResponseEntity<List<Cities>>(service.findAll(), HttpStatus.OK);
	}
}
