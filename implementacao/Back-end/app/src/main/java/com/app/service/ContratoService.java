package com.app.service;

import org.springframework.stereotype.Service;

import com.app.model.Contrato;
import com.app.repository.ContratoRepository;

@Service
public class ContratoService {
    
    private final ContratoRepository CONTRATO_REPOSITORY;

    public ContratoService(ContratoRepository contratoRepository){
        this.CONTRATO_REPOSITORY = contratoRepository;
    }

    public void insereCliente(Contrato contrato){
        CONTRATO_REPOSITORY.save(null);
    }

}
