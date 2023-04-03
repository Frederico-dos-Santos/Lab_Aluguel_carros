package com.app.repository;

import com.app.model.Rendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendimentoRepository extends JpaRepository<Rendimento, Long> {
}
