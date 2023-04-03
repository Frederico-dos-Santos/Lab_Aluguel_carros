package com.app.service;

import com.app.model.EntidadeEmpregadora;
import com.app.repository.EntidadeEmpregadoraRepository;
import org.springframework.stereotype.Service;

@Service
public class EntidadeEmpregadoraService {

    private final EntidadeEmpregadoraRepository ENTIDADEEMPREGADORA_REPOSITORY;

    public EntidadeEmpregadoraService(EntidadeEmpregadoraRepository entidadeEmpregadoraRepository) {
        this.ENTIDADEEMPREGADORA_REPOSITORY = entidadeEmpregadoraRepository;
    }

    public void insereEntidadeEmpregadora(EntidadeEmpregadora entidadeEmpregadora){
        ENTIDADEEMPREGADORA_REPOSITORY.save(entidadeEmpregadora);
    }
}
