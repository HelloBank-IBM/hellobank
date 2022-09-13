package com.hellobank.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.ContaDAO;
import com.hellobank.Model.Conta;

@Service
public class ContaServiceImpl implements IContaService {

    @Autowired
    private ContaDAO dao;

    @Override
    public Conta criarConta(Conta conta) {
        if(conta.getCliente() != null && conta.getTipo() != null && conta.getSaldo() != null){
            dao.save(conta);
           }
        return null;
    }

    @Override
    public Conta atualizarConta(Conta conta) {
       if(conta.getNumeroConta() != null && conta.getCodigo() != null && conta.getCliente() != null && conta.getTipo() != null && conta.getSaldo() != null){
        dao.save(conta);
       }
        return null;
    }

    @Override
    public ArrayList<Conta> buscarContas() {
        ArrayList<Conta> lista;
        lista = (ArrayList<Conta>) dao.findAll();
        return lista;
    }

    @Override
    public Conta buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null); 
    }

    @Override
    public void excluirConta(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Integer criarNumeroConta(Conta conta) {
        Integer numeroBanco = 71;
        // instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();
        int[] num = new int[4];
        for (int i = 0; i < num.length; i++) {
            int numero = gerador.nextInt(9);
            num[i] = numero;
        }
        String numero = "";
        for (int i = 0; i < num.length; i++) {
            numero = numero + String.valueOf(num[i]);
        }
        numero = String.valueOf(numeroBanco) + numero + String.valueOf(conta.getTipo().getCodigo());
        Integer numeroConta = Integer.parseInt(numero);
        return numeroConta;
    }
        
    }
  

