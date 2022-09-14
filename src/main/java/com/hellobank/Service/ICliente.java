package com.hellobank.Service;


import java.util.ArrayList;

import com.hellobank.Model.Cliente;

public interface ICliente {
    
    public ArrayList<Cliente> buscarTodos();
    public Cliente salvar(Cliente cliente);
    public Cliente atualizarDados(Cliente cliente);
    public  Cliente buscarPeloId(Integer id);
	public ArrayList<Cliente> buscarPeloCpf(String cpf);
    public void excluir(Integer id);

}
