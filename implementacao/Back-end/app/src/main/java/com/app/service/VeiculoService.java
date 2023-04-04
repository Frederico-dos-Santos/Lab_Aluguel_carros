package com.app.service;

import org.springframework.stereotype.Service;

import com.app.model.Veiculo;
import com.app.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {
    
    private final VeiculoRepository VEICULO_REPOSITORY;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.VEICULO_REPOSITORY = veiculoRepository;
    }

    public void insereVeiculo(Veiculo veiculo){
        VEICULO_REPOSITORY.save(veiculo);
    }

    public boolean veiculoExiste(Veiculo veiculo){

        return VEICULO_REPOSITORY.findVeiculoByPlaca(veiculo.getPlaca()) != null;
    }

    public Veiculo retornaVeiculoPeloId(Long id){
        return VEICULO_REPOSITORY.getReferenceById(id);
    }

    public List<Veiculo> retornaTodosVeiculos(){
        return VEICULO_REPOSITORY.findAll();
    }

    public void alteraCarro(Veiculo veiculo){
        VEICULO_REPOSITORY.save(veiculo);
    }
}
