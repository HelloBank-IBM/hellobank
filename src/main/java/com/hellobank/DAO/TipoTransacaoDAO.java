package com.hellobank.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.TipoTransacao;
import com.hellobank.Model.Transacao;

public interface TipoTransacaoDAO extends CrudRepository<TipoTransacao,Integer> {

    @Query(value="select * from tipo_transacao where id_tipo_transacao=:numero",nativeQuery = true) 
    public TipoTransacao buscarNum(Integer numero);
    
    
}
