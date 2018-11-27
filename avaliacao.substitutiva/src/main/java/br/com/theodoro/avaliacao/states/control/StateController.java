package br.com.theodoro.avaliacao.states.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.theodoro.avaliacao.states.model.States;
import br.com.theodoro.avaliacao.states.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

	@Autowired
	private StateService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public void salvar(@RequestBody States states) {
		service.save(states);
	}

	@RequestMapping(value = "/deletar/{idStates}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("idStates") Long id) {
		service.delete(id);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<States>> listarTodos() {
		return new ResponseEntity<List<States>>(service.findAll(), HttpStatus.OK);
	}
}
