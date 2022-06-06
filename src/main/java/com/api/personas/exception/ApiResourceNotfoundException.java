package com.api.personas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion Not foud 404
 * 
 * @author gabo
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiResourceNotfoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApiResourceNotfoundException(String message) {
		super(message);

	}

}
