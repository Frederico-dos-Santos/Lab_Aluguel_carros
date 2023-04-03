package com.app.controller;

import com.app.dto.ClienteDTO;
import com.app.model.Cliente;
import com.app.model.EntidadeEmpregadora;
import com.app.model.Rendimento;
import com.app.service.ClienteService;
import com.app.service.EntidadeEmpregadoraService;
import com.app.service.RendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cliente/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService CLIENTE_SERVICE;

    private final RendimentoService RENDIMENTO_SERVICE;

    private final EntidadeEmpregadoraService ENTIDADEEMPREGADORA_SERVICE;


    public ClienteController(ClienteService clienteService, RendimentoService rendimentoService,
                             EntidadeEmpregadoraService entidadeEmpregadoraService) {
        this.CLIENTE_SERVICE = clienteService;
        this.RENDIMENTO_SERVICE = rendimentoService;
        this.ENTIDADEEMPREGADORA_SERVICE = entidadeEmpregadoraService;
    }

    @PostMapping(value = "/insereCliente")
    public ResponseEntity<?> insereCliente(@RequestBody ClienteDTO cliente){

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Cliente cliente_inserir = new Cliente(cliente.getName(), cliente.getPassword(), cliente.getEmail(),
                cliente.getCpf(), cliente.getRg(), cliente.getEndereco(), cliente.getProfissao());

        if(CLIENTE_SERVICE.clienteExiste(cliente_inserir)){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        CLIENTE_SERVICE.insereCliente(cliente_inserir);

        Double[] rendimentos = {cliente.getSalario1(), cliente.getSalario2(), cliente.getSalario3()};

        for (Double rendimento : rendimentos) {

            if(rendimento != null){

                Rendimento rendimento_inserir = new Rendimento(rendimento, cliente_inserir);

                RENDIMENTO_SERVICE.insereRendimento(rendimento_inserir);

            }
        }

        String[] entidadeEmpregadoras = {cliente.getEntidadeEmpregadora1(), cliente.getEntidadeEmpregadora2(),
                cliente.getEntidadeEmpregadora3()};

        for(String entidade : entidadeEmpregadoras){

            if(entidade != null){

                EntidadeEmpregadora entidadeEmpregadora = new EntidadeEmpregadora(entidade, cliente_inserir);

                ENTIDADEEMPREGADORA_SERVICE.insereEntidadeEmpregadora(entidadeEmpregadora);
            }
        }

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
