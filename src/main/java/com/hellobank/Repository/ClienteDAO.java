package com.hellobank.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente,Integer> {
    public Optional<Cliente> findByEmail(String email);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where email = :email",  nativeQuery = true)
    public boolean emailExiste(String email);
}
