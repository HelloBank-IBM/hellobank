package com.hellobank.Service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellobank.DAO.TipoTransacaoDAO;
import com.hellobank.DAO.TransacaoDAO;
import com.hellobank.Model.Conta;
import com.hellobank.Model.Transacao;

@Service
public class TransacaoServiceImpl   implements ITransacaoService{
	
	@Autowired
	private TransacaoDAO dao;

	@Autowired
	private TipoTransacaoDAO tipoTransacaoDao;
	
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
	public Transacao salvarTransacao(Conta contaOrigem, Conta contaDestino, Float valor, Integer idTipoTransacao){
		Transacao transacao = new Transacao();
		LocalDate data = LocalDate.now();

		transacao.setContaOrigem(contaOrigem);
		transacao.setContaDestino(contaDestino);
		transacao.setTipoTransacao(tipoTransacaoDao.findById(idTipoTransacao).get());
		transacao.setValor(valor);
		transacao.setData(data);

		return dao.save(transacao);
	}

	@Override
	public Transacao salvarTransacao(Conta contaOrigem, Float valor, Integer idTipoTransacao){
		Transacao transacao = new Transacao();
		LocalDate data = LocalDate.now();

		transacao.setContaOrigem(contaOrigem);
		transacao.setTipoTransacao(tipoTransacaoDao.findById(idTipoTransacao).get());
		transacao.setValor(valor);
		transacao.setData(data);

		return dao.save(transacao);
	}

	public ArrayList<Transacao> extrato(Integer idConta){
		return dao.extrato(idConta);
	}
}
