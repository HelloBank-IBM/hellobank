package com.hellobank.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	@Query(value="select * from transacao where conta_origem =:id",nativeQuery = true)
    public  ArrayList<Transacao> buscarPeloIdNumero(Integer id);
	
}
