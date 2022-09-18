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

import com.hellobank.Model.Cliente;
import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoConta;
import com.hellobank.Model.Transacao;
import com.hellobank.Service.ContaServiceImpl;
import com.hellobank.Service.TransacaoServiceImpl;

@RestController
public class ContaController {

    @Autowired
    private ContaServiceImpl service;

    @Autowired
    private TransacaoServiceImpl serviceTransacao;

    @GetMapping("/conta")
    public ArrayList<Conta> buscarContas() {
        return service.buscarContas();
    }

    @PostMapping("/conta")
    public ResponseEntity<Conta> incluirNovo(@RequestBody Conta novo) {
        Cliente cliente = novo.getCliente();
        TipoConta tipoConta = novo.getTipo();
        Boolean contaExiste = service.contaExiste(cliente, tipoConta);

        if (contaExiste == false) {
            // Criando e preenchendo o númeroConta da conta
            var numeroConta = service.criarNumeroConta(novo);
            novo.setNumeroConta(numeroConta);
            // Inserindo saldo obrigatorio no registro de conta
            Float saldoInicial = 500f;
            novo.setSaldo(saldoInicial);
            // Verificando se o cliente existe no banco de dados e se o tipo conta está
            // preenchido;
            service.criarConta(novo);
            Conta res = service.buscarPeloNumero(novo.getNumeroConta());
            System.out.println("Id da nova conta: " + res.getId());
            if (res != null) {
                System.out.println("Conta salva com sucesso");
                return ResponseEntity.ok(res);
            }
            System.out.println("Erro ao salvar conta");
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/conta/{numeroConta}")
    public ResponseEntity<Conta> excluirConta(@PathVariable Integer numeroConta) {
        Conta conta = service.buscarPeloNumero(numeroConta);
        if (conta != null){
            service.excluirConta(conta.getId());
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/conta/{numeroConta}")
    public ResponseEntity<Conta> bucarPeloNumeroConta(@PathVariable Integer numeroConta) {
        Conta res = service.buscarPeloNumero(numeroConta);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/depositar/{numeroConta}/{valor}")
    public ResponseEntity<Conta> depositar(@PathVariable float valor, @PathVariable Integer numeroConta) {

        Conta aux = service.buscarPeloNumero(numeroConta);
        Conta res = service.depositar(aux, valor);
        if (res != null) {
            //método 'salvarTransacao': cria e salva transação no banco de dados com a data atual
            //Parâmetros: contaOrigem (objeto da Classe Conta), valor (float), idTipoTransacao(integer). 
            //Para idTipoTransacao: 1 == depósito, 2 == saque, 3 == transferência
            serviceTransacao.salvarTransacao(aux, valor, 1);
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/transferencia/{numeroOrigem}/{valor}/{numeroDestino}")
    public ResponseEntity<Conta> transferencia(@PathVariable float valor, @PathVariable Integer numeroOrigem, @PathVariable Integer numeroDestino) {

        Conta auxOrigem = service.buscarPeloNumero(numeroOrigem);
        Conta auxDestino = service.buscarPeloNumero(numeroDestino);
        Conta res = service.transferencia(auxOrigem, valor, auxDestino);

        if (res != null) {
            //método 'salvarTransacao': cria e salva transação no banco de dados com a data atual
            //Parâmetros: contaOrigem (objeto da Classe Conta), valor (float), idTipoTransacao(integer). 
            //Para idTipoTransacao: 1 == depósito, 2 == saque, 3 == transferência
            serviceTransacao.salvarTransacao(auxOrigem, auxDestino, valor, 3);
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/saque/{numeroConta}/{valor}")
    public ResponseEntity<Conta> saque(@PathVariable Integer numeroConta, @PathVariable Float valor){
        Conta conta = service.buscarPeloNumero(numeroConta); 
        Conta res = service.sacar(conta, valor);
        if (res != null){
            //método 'salvarTransacao': cria e salva transação no banco de dados com a data atual
            //Parâmetros: contaOrigem (objeto da Classe Conta), valor (float), idTipoTransacao(integer). 
            //Para idTipoTransacao: 1 == depósito, 2 == saque, 3 == transferência
            serviceTransacao.salvarTransacao(conta, valor, 2);
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
