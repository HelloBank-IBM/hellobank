package com.hellobank.Daos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hellobank.Model.Cliente;
import com.hellobank.Repository.ClienteDAO;
import com.hellobank.Service.ICliente;
@SpringBootTest
class ClienteTeste {

	@Autowired
	private ClienteDAO dao;
	
	@Test
	void validarSeEmailCadastradoExiste() {
    
		Boolean clienteExistente = dao.emailExiste("amanda@teste.com");
        
        assertEquals(true, clienteExistente);
    
	}
	
	@Test
	void validarSeEmailCadastradoNaoExiste() {
		var clienteNaoExiste = dao.emailExiste("amanda@oi.com");
		assertEquals(false, clienteNaoExiste);
	}
	
/* 
	@Test
	void validarFindDoDaoDeCliente() {
		assertEquals(2, dao.count());
	}
*/
}
