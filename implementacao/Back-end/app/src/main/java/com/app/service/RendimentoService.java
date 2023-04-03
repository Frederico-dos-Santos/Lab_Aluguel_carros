package com.app.service;

import com.app.model.Rendimento;
import com.app.repository.RendimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class RendimentoService {

    private final RendimentoRepository RENDIMENTO_REPOSITORY;

    public RendimentoService(RendimentoRepository rendimentoRepository) {
        this.RENDIMENTO_REPOSITORY = rendimentoRepository;
    }

    public void insereRendimento(Rendimento rendimento){
        RENDIMENTO_REPOSITORY.save(rendimento);
    }

}
