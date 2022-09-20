package com.hellobank.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	
@Query(value="SELECT * FROM transacao WHERE conta_origem = :idConta ORDER BY id_transacao DESC", nativeQuery=true)
public ArrayList<Transacao> extrato(Integer idConta);
	
}
