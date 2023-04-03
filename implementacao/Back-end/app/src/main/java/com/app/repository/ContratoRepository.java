package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{
    
}
