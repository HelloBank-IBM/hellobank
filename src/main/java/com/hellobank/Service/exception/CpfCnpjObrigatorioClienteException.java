
package com.hellobank.Service.exception;

public class CpfCnpjObrigatorioClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CpfCnpjObrigatorioClienteException(String message) {
		super(message);
	}

}