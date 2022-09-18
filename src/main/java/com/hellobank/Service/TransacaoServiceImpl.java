package com.hellobank.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.ContaDAO;
import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Conta;
import com.hellobank.Model.Transacao;

@Service
public class TransacaoServiceImpl   implements ITransacaoService{
	
	@Autowired
	private TransacaoDAO dao;
	
	@Autowired
	private ContaDAO contaDao;

    @Override
	public Transacao buscar(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
    @Override
	public Transacao salvar(Transacao novo) {
		return dao.save(novo);
	}
	
    @Override
	public ArrayList<Transacao> listar() {
		return (ArrayList<Transacao>)dao.findAll();
	
	}

	@Override
	public ArrayList<Transacao> extrato(Integer numero) {
		Conta aux = contaDao.buscarNum(numero);
		//fazendo uma copia
		var transacoes=new ArrayList<>(dao.buscarPeloIdNumero(aux.getId()));
		//var transacoes=dao.buscarPeloIdNumero(aux.getId());
		///nao ficou legal
		for(Transacao t : transacoes){
			if(t.getTipoTransacao().getId()==3){
					return transacoes;
			}else{
				t.getContaOrigem().setCliente(null);	
					return transacoes;
			//nao queria para aparecer o cliente pois ja quem ele é pelo seu numero é muita informação na tela
			//se nao tiver problema desconsidera essa parte
			}
						
		}
		return null;
	}
	
}
