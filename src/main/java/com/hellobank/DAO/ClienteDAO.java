package com.hellobank.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hellobank.Model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente,Integer> {
    public Optional<Cliente> findByEmail(String email);

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where email = :email",  nativeQuery = true)
    public boolean emailExiste(String email);
    public Cliente findByCpfCnpj(String cpf);

    @Query(value="select c from cliente c where c.id_cliente = ?1", nativeQuery = true)
    public Cliente encontrarPorId(Integer id);

    @Query(value="select c from cliente c where c.cpfCnpj = ?1", nativeQuery = true)
    public Cliente encontrarPorCpf(String cpf);
}
