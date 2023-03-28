package com.app.repository;

import com.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Cliente findClienteByCpf(@Param("cpf") String cpf);

    Cliente findClienteByEmail(@Param("email") String email);

}
