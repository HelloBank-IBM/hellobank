package com.hellobank.Controller;

import java.time.LocalDate;
import java.time.ZoneId;
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

import com.hellobank.DAO.TipoTransacaoDAO;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoTransacao;
import com.hellobank.Model.Transacao;
import com.hellobank.Service.ContaServiceImpl;
import com.hellobank.Service.TransacaoServiceImpl;
@RestController
public class ContaController {

    @Autowired
    private  ContaServiceImpl service;
    @Autowired
    private  TipoTransacaoDAO dao;

    @Autowired
    private  TransacaoServiceImpl serviceTransacao;
    

    @GetMapping("/conta")
    public ArrayList<Conta> buscarContas(){
        return service.buscarContas();
    }
    
    @PostMapping("/conta")
    public ResponseEntity<Conta> incluirNovo(@RequestBody Conta novo){
        //Criando e preenchendo o númeroConta da conta
        var numeroConta =service.criarNumeroConta(novo);
        novo.setNumeroConta(numeroConta);
        //Inserindo saldo obrigatorio no registro de conta
        Float saldoInicial = 500f;
        novo.setSaldo(saldoInicial);
        //Verificando se a conta já existe pelo id.
        if(service.buscarPeloId(novo.getId()) != null){
            return null;
        }
        //Verificando se o cliente existe no banco de dados e se o tipo conta está preenchido;
        Conta res =service.criarConta(novo);
        if(res != null){
                return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/conta/{id}")
    public ResponseEntity<Conta> excluirConta(@PathVariable Integer id){
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
    @PutMapping("/depositar/{valor}/{numero}")
    public ResponseEntity<Conta> depositar(@PathVariable float valor,@PathVariable Integer numero){
       
        Conta aux=service.buscarPeloNumero(numero);
        Transacao transacao = new Transacao();
           
        Conta res=service.depositar(aux, valor,transacao);
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/transferencia/{valor}/{numeroOrigem}/{numeroDestino}")
    public ResponseEntity<Conta> transferencia(@PathVariable float valor,@PathVariable Integer numeroOrigem,@PathVariable Integer numeroDestino){
        Transacao transacao = new Transacao();
        Conta auxOrigem=service.buscarPeloNumero(numeroOrigem);
        Conta auxDestino=service.buscarPeloNumero(numeroDestino);
        Conta res=service.transferencia(auxOrigem, valor, auxDestino,transacao);
        
		if (res!=null) {
			return ResponseEntity.ok(res);
		}
        return ResponseEntity.notFound().build();
    }
    
}
