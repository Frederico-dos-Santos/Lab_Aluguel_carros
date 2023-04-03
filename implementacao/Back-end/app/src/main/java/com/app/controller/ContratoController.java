package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ContratoDTO;
import com.app.model.Cliente;
import com.app.model.Contrato;
import com.app.model.Veiculo;
import com.app.service.ClienteService;
import com.app.service.ContratoService;
import com.app.service.VeiculoService;

@RestController
@RequestMapping(value = "/api/contrato/")
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

        CONTRATO_SERVICE.insereCliente(contrato);

        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    

}
