package com.api.personas.exception;

public class ErrorMensaje {

	private String mensaje;
	private String exception;

	public ErrorMensaje(Exception exception) {

		this(exception.getClass().getSimpleName(), exception.getMessage());
	}

	public ErrorMensaje(String exception, String message) {
		this.exception = exception;
		this.mensaje = message;
	}

	@Override
	public String toString() {
		return "ErrorMensaje [mensaje=" + mensaje + ", exception=" + exception + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}
