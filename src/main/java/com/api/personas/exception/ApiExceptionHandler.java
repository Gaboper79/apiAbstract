package com.api.personas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ ApiResourceNotfoundException.class, })
	@ResponseBody
	public ErrorMensaje notFoundRequest(Exception exception) {
		return new ErrorMensaje(exception);
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler({ Exception.class, ApiUnprocessableEntityException.class })
	public ErrorMensaje badRequest(Exception exception) {
		return new ErrorMensaje(exception);
	}

}
