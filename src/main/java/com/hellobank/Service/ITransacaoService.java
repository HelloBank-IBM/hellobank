package com.hellobank.Service;

import java.util.ArrayList;
import java.util.List;

import com.hellobank.Model.Transacao;

public interface ITransacaoService {
	
	public Transacao salvar (Transacao novo);
	public Transacao buscar (Integer id_transacao);
	public ArrayList<Transacao> listar();
	public ArrayList<Transacao> extrato(Integer numero);

}
