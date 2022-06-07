package com.api.personas.exception;

/**
 * Excepcion Not foud 404
 * 
 * @author gabo
 *
 */

public class ApiResourceNotfoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String DESCRIPCION = "Recurso no encontrado";

	public ApiResourceNotfoundException() {
		super(DESCRIPCION);

	}

	public ApiResourceNotfoundException(String detail) {
		super(DESCRIPCION + "-" + detail);

	}

}
