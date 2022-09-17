package com.hellobank.DAO;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Conta;

public interface ContaDAO extends CrudRepository< Conta, Integer> {
    boolean existsById(Integer id);
    @Query(value="select * from conta where numero_conta=:numero",nativeQuery = true) 
    public Conta buscarNum(Integer numero);
}
