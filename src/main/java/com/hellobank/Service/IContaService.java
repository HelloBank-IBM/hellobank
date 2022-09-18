package com.hellobank.Service;

import java.util.ArrayList;

import com.hellobank.Model.Conta;
import com.hellobank.Model.Transacao;

public interface IContaService {
    
    public Conta criarConta(Conta conta);
    public ArrayList<Conta> buscarContas();
    public Conta buscarPeloNumero(Integer numero);
    public Conta buscarPeloId(Integer id);
    public void excluirConta(Integer id);
    public Integer criarNumeroConta(Conta conta);
    public Conta depositar(Conta conta, float valor,Transacao transacao);
    public Conta transferencia(Conta conta, float valor,Conta contaDestino,Transacao transacao);

}
