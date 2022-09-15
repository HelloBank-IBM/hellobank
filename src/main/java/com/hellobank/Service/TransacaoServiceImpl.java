package com.hellobank.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Transacao;

@Service
public class TransacaoServiceImpl   implements ITransacaoService{
	
	@Autowired
	private TransacaoDAO dao;
	
    @Override
	public Transacao buscar(Integer id_transacao) {
		return dao.findById(id_transacao).orElse(null);
	}
	
    @Override
	public Transacao salvar(Transacao novo) {
		return dao.save(novo);
	}
	
    @Override
	public List<Transacao> listar() {
		return (ArrayList<Transacao>)dao.listar();
	
	}
}
