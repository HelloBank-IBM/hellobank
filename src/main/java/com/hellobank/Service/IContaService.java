package com.hellobank.Service;

import java.util.ArrayList;

import com.hellobank.Model.Conta;

public interface IContaService {
    
    public Conta criarConta(Conta conta);
    public ArrayList<Conta> buscarContas();
    public Conta buscarContasCpf(Integer cpf);
    public Conta buscarPeloId(Integer id);
    public void excluirConta(Integer id);
    public Integer criarNumeroConta(Conta conta);

}
