package com.hellobank.DAO;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hellobank.Model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente,Integer> {

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from cliente where email = :email",  nativeQuery = true)
    public boolean emailExiste(String email);
    public Cliente findByCpfCnpj(String cpf);

    @Query(value="select c from cliente c where c.id_cliente = ?1", nativeQuery = true)
    public Cliente encontrarPorId(Integer id);

    @Query(value="select c from cliente c where c.cpfCnpj = ?1", nativeQuery = true)
    public Cliente encontrarPorCpf(String cpf);
    public Optional<Cliente> findByEmail(String cpf);

    @Transactional
    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query(value="update cliente c set c.nome = :inome, c.email = :iemail, c.senha = :isenha, c.endereco = :iendereco, c.contato = :icontato where c.idCliente = :idCliente", nativeQuery=true)
    public void atualizar(@Param("inome")String inome, @Param("iemail")String iemail, @Param("isenha")String isenha, @Param("iendereco")String iendereco,@Param("icontato") String icontato, @Param("idCliente")Integer idCliente);
}
