package com.app.service;

import org.springframework.stereotype.Service;

import com.app.model.Contrato;
import com.app.repository.ContratoRepository;

import java.util.List;

@Service
public class ContratoService {
    
    private final ContratoRepository CONTRATO_REPOSITORY;

    public ContratoService(ContratoRepository contratoRepository){
        this.CONTRATO_REPOSITORY = contratoRepository;
    }

    public void insereContrato(Contrato contrato){
        CONTRATO_REPOSITORY.save(contrato);
    }

    public List<Contrato> retornaTodosContratos(){
        return CONTRATO_REPOSITORY.findAll();
    }

    public boolean contratoExiste(Contrato contrato){

        Contrato contratoProcurar = CONTRATO_REPOSITORY.findContratoById(contrato.getId());

        return contratoProcurar == null;

    }

    public void deletaContrato(Contrato contrato){
        CONTRATO_REPOSITORY.delete(contrato);
    }

    public Contrato retornaContratoPeloId(Long id){
        return CONTRATO_REPOSITORY.findContratoById(id);
    }


}
