package com.hellobank.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.TipoConta;

public interface TipoContaDAO extends CrudRepository <TipoConta, Integer>{

    @Query(value="SELECT * FROM tipo_conta t WHERE t.id_tipo_conta = ?1", nativeQuery=true)
    public TipoConta encontrarPorId(Integer id);

}
