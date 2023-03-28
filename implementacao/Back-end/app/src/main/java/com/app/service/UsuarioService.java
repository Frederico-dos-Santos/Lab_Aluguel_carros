package com.app.service;

import com.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository USUARIO_REPOSITORY;

    public UsuarioService(UsuarioRepository USUARIO_REPOSITORY) {
        this.USUARIO_REPOSITORY = USUARIO_REPOSITORY;
    }
}
