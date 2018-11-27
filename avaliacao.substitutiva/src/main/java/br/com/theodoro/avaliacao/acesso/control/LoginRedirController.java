package br.com.theodoro.avaliacao.acesso.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**Classe para objetos do tipo LoginRedirController, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
@Controller
@RequestMapping("/loginRedir")
public class LoginRedirController {
	

	/**
	 * redirect para /
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String redir(){
		return "redirect:/";
	}
	
}
