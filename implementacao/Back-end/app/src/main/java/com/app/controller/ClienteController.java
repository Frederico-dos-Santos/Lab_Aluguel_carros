package com.app.controller;

import com.app.model.Cliente;
import com.app.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cliente/")
public class ClienteController {

    private final ClienteService CLIENTE_SERVICE;

    public ClienteController(ClienteService CLIENTE_SERVICE) {
        this.CLIENTE_SERVICE = CLIENTE_SERVICE;
    }

    @PostMapping(value = "/insereCliente")
    public ResponseEntity<?> insereCliente(@RequestBody Cliente cliente){

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        if(CLIENTE_SERVICE.clienteExiste(cliente)){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        CLIENTE_SERVICE.insereCliente(cliente);

        return ResponseEntity.ok().body(HttpStatus.OK);


    }

    @DeleteMapping(value = "/deletaCliente/{id}")
    public ResponseEntity<?> deletaCliente(@PathVariable Long id){

        if(id == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Cliente cliente = CLIENTE_SERVICE.retornaClientePeloId(id);

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        CLIENTE_SERVICE.deletaCliente(cliente);

        return ResponseEntity.ok().body(HttpStatus.OK);

    }

}
