package com.hellobank.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Conta;

public interface ContaDAO extends CrudRepository< Conta, Integer> {
    boolean existsById(Integer id);
}
