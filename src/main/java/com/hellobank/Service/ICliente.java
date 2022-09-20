package com.hellobank.Service;


import java.util.ArrayList;

import com.hellobank.Model.Cliente;
import com.hellobank.Model.TipoConta;

public interface ICliente {
    
    public ArrayList<Cliente> buscarTodos();
    public Cliente salvar(Cliente cliente);
    public Cliente atualizarDados(Cliente cliente);
    public Cliente buscarPeloId(Integer id);
    public void excluir(Integer id);
    public Cliente buscarPeloCpf(String cpf);
    public Cliente buscarPeloEmail(String email);
    public void atualizar(Cliente cliente);

}
