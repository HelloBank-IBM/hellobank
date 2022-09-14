package com.hellobank.Service.exception;

public class EmailClienteJaCadastradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;
	
	public EmailClienteJaCadastradoException(String mensagem) {
		super(mensagem);
	}
	
	public EmailClienteJaCadastradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

