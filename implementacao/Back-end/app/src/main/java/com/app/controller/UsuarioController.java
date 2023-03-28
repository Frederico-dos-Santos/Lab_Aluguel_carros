package com.app.controller;

import com.app.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/usuario/")
public class UsuarioController {

    private final UsuarioService USUARIO_SERVICE;

    public UsuarioController(UsuarioService usuarioService) {
        this.USUARIO_SERVICE = usuarioService;
    }




}
