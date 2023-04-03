package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Veiculo;
import com.app.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculo/")
public class VeiculoController {
    
    private final VeiculoService VEICULO_SERVICE;

    public VeiculoController(VeiculoService veiculoService){
        this.VEICULO_SERVICE = veiculoService;
    }

    @PostMapping(value = "insereVeiculo")
    public ResponseEntity<?> insereVeiculo(@RequestBody Veiculo veiculo){

        if(veiculo == null){
            ResponseEntity.badRequest().body(HttpStatus.NO_CONTENT);
        }

        if(VEICULO_SERVICE.veiculoExiste(veiculo)){
            ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

        VEICULO_SERVICE.insereVeiculo(veiculo);

        return ResponseEntity.ok(HttpStatus.OK);

    }

}
