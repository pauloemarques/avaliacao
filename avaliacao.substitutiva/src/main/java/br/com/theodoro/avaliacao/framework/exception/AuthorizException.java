package br.com.theodoro.avaliacao.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthorizException extends Exception{
	
	public AuthorizException(String message) {
		super(message);
	}
}
