package com.hellobank.Service;

import java.util.ArrayList;

import com.hellobank.Model.Conta;
import com.hellobank.Model.TipoTransacao;
import com.hellobank.Model.Transacao;

public interface ITransacaoService {
	
	public Transacao salvar (Transacao novo);
	public Transacao buscar (Integer id_transacao);
	public ArrayList<Transacao> listar();
	public Transacao salvarTransacao(Conta contaOrigem, Float valor, Integer idTipoTransacao);
	public Transacao salvarTransacao(Conta contaOrigem, Conta contaDestino, Float valor, Integer idTipoTransacao);
	public ArrayList<Transacao> extrato(Integer idConta);

}
