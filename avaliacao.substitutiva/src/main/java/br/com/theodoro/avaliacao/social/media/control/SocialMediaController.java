package br.com.theodoro.avaliacao.social.media.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.theodoro.avaliacao.social.media.model.SocialMedia;
import br.com.theodoro.avaliacao.social.media.service.SocialMediaService;

@RestController
@RequestMapping("/socialMedia")
public class SocialMediaController {

	@Autowired
	private SocialMediaService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public void salvar(@RequestBody SocialMedia socialMedia) {
		service.save(socialMedia);
	}

	@RequestMapping(value = "/deletar/{idSocialMedia}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("idSocialMedia") Long id) {
		service.delete(id);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<SocialMedia>> listarTodos() {
		return new ResponseEntity<List<SocialMedia>>(service.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/listarTodosDoUsuario", method = RequestMethod.GET)
	public ResponseEntity<List<SocialMedia>> listarTodosDoUsuario() {
		return new ResponseEntity<List<SocialMedia>>(service.findByUser(), HttpStatus.OK);
	}
}
