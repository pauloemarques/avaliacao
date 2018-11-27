package br.com.theodoro.avaliacao.acesso.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.acesso.service.AuthService;
import br.com.theodoro.avaliacao.acesso.service.UserService;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService usuarioService;
	
	/**
	 * @throws BusinessException
	 * @return the Usuario
	 */
	@RequestMapping(value="/current", method = RequestMethod.GET)
	public ResponseEntity<?> current() throws BusinessException {
		
		User user = authService.getCurrent();
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * @throws BusinessException
	 * @param id the id to set
	 * @param nome the nome to set
	 * @return the List<Usuario>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> list(
			@RequestParam(required=false) Long id,
			@RequestParam(required=false) String nome) throws BusinessException {
		
		return new ResponseEntity<List<User>>(usuarioService.findAll(), HttpStatus.OK);
	}
}
