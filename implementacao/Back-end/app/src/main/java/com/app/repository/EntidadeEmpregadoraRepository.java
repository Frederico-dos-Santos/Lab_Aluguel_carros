package com.app.repository;

import com.app.model.EntidadeEmpregadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeEmpregadoraRepository extends JpaRepository<EntidadeEmpregadora, Long> {
}
