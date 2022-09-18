package com.hellobank.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellobank.Model.Cliente;
import com.hellobank.Service.ICliente;

@RestController
public class ClienteController {
    
    @Autowired
    private ICliente service;

    @GetMapping("/cliente")
    public ArrayList<Cliente> recuperarTodos(){
		return service.buscarTodos();
		
	}

    @PostMapping("/cliente")
	public ResponseEntity<Cliente> inserirNovo(@RequestBody Cliente novo) {
		Cliente res=service.salvar(novo);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	
	}

    @PutMapping("/cliente")
	public ResponseEntity<Cliente> atualizarDados(@RequestBody Cliente dados){
		Cliente res=service.atualizarDados(dados);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Integer id) {
	
		service.excluir(id);
		return ResponseEntity.ok(null);
	}
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> buscarId(@PathVariable Integer id){
		Cliente res=service.buscarPeloId(id);
		if(res!=null) {
			return ResponseEntity.ok(res);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
