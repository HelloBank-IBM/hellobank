package com.hellobank.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hellobank.Model.Conta;
import com.hellobank.service.ContaServiceImpl;

public class ContaController {

    @Autowired
    private ContaServiceImpl service;

    @GetMapping("/conta")
    public ArrayList<Conta> buscarContas(){
        return service.buscarContas();
    }
    
    @PostMapping("/conta")
    public ResponseEntity<Conta> incluirNovo(@RequestBody Conta novo){
        Integer numeroConta =service.criarNumeroConta(novo) ;
        novo.setNumeroConta(numeroConta);
        Conta res =service.criarConta(novo);
        
        if(res != null){
                return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/conta/{id}")
    public ResponseEntity<Conta> excluirDepartamento(@PathVariable Integer id){
        service.excluirConta(id);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/conta/{id}")
    public ResponseEntity<Conta> bucarPeloId(@PathVariable Integer id){
        Conta res =service.buscarPeloId(id);
        if(res != null){
                return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
