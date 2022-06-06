package com.api.personas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepcion status 422
 * 
 * @author gabo
 *
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntityException extends Exception {
	private static final long serialVersionUID = 1L;

	public ApiUnprocessableEntityException(String message) {
		super(message);
	}
}
