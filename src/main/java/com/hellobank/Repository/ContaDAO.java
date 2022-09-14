package com.hellobank.Repository;

import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Conta;

public interface ContaDAO extends CrudRepository< Conta, Integer> {
    boolean existById(Integer id);
}
