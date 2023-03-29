package com.app.controller;

import com.app.model.Cliente;
import com.app.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cliente/")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(value = "/retornaTodosClientes")
    public ResponseEntity<?> retornaTodosClientes(){

        List<Cliente> clientes = CLIENTE_SERVICE.retornaTodosClientes();

        return ResponseEntity.ok().body(clientes);

    }

    @GetMapping(value = "/retornaClientePeloEmail/{email}")
    public ResponseEntity<?> retornaClientePorEmail(@PathVariable String email){

        if(email == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Cliente cliente = CLIENTE_SERVICE.retornaClientePeloEmail(email);

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(cliente);

    }

    @PutMapping(value = "/alteraCliente")
    public ResponseEntity<?> alteraCliente(@RequestBody Cliente cliente){

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        CLIENTE_SERVICE.deletaCliente(cliente);
        CLIENTE_SERVICE.insereCliente(cliente);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
