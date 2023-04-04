package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ContratoDTO;
import com.app.model.Cliente;
import com.app.model.Contrato;
import com.app.model.Veiculo;
import com.app.service.ClienteService;
import com.app.service.ContratoService;
import com.app.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contrato/")
@CrossOrigin(origins = "http://localhost:4200")
public class ContratoController {
    
    private final ContratoService CONTRATO_SERVICE;

    private final ClienteService CLIENTE_SERVICE;

    private final VeiculoService VEICULO_SERVICE;


    public ContratoController(ContratoService contratoService, ClienteService clienteService, 
    VeiculoService veiculoService){
        CONTRATO_SERVICE = contratoService;
        CLIENTE_SERVICE = clienteService;
        VEICULO_SERVICE = veiculoService;
    }

    
    @PostMapping(value = "criaContrato")
    public ResponseEntity<?> criaContrato(@RequestBody ContratoDTO contratoDTO){

        if(contratoDTO == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Long idVeiculo = contratoDTO.getIdVeiculo();
        Long idCliente = contratoDTO.getIdCliente();

        if(idVeiculo == null || idCliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }
        
        Veiculo veiculo = VEICULO_SERVICE.retornaVeiculoPeloId(idVeiculo);

        if(veiculo == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        Cliente cliente = CLIENTE_SERVICE.retornaClientePeloId(idCliente);

        if(cliente == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        Contrato contrato = new Contrato(contratoDTO.isAtivo(), contratoDTO.getValor(), 
        contratoDTO.isContratoCredito(), veiculo, cliente);

        CONTRATO_SERVICE.insereContrato(contrato);

        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping(value = "retornaTodosContratos",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retornaTodosContratos(){

        List<Contrato> contratos = CONTRATO_SERVICE.retornaTodosContratos();

        if(contratos == null || contratos.isEmpty()){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(contratos);


    }

    @PostMapping(value = "alteraContrato")
    public ResponseEntity<?> alteraContrato(@RequestBody Contrato contrato){

        if(contrato == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        if(!CONTRATO_SERVICE.contratoExiste(contrato)){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        Contrato contratoAntigo = CONTRATO_SERVICE.retornaContratoPeloId(contrato.getId());

        CONTRATO_SERVICE.deletaContrato(contratoAntigo);
        CONTRATO_SERVICE.insereContrato(contrato);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "retornaContratoPeloId/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retornaContratoPeloId(@PathVariable Long id){

        if(id == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Contrato contrato = CONTRATO_SERVICE.retornaContratoPeloId(id);

        if(contrato == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(contrato);

    }

    /*@GetMapping(value = "deletaContratoPeloId/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletaContratoPeloId(@PathVariable Long id){

        if(id == null){
            return ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        Contrato contrato = CONTRATO_SERVICE.retornaContratoPeloId(id);

        if(contrato == null){
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        CONTRATO_SERVICE.deletaContrato(contrato);

        return ResponseEntity.ok(contrato);

    }*/

}
