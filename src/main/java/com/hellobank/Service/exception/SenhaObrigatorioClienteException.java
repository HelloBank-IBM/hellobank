
package com.hellobank.Service.exception;

public class SenhaObrigatorioClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SenhaObrigatorioClienteException(String message) {
		super(message);
	}

}