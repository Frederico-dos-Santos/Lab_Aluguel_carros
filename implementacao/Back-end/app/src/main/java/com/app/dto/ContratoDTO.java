package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {
    
    private Long idCliente;

    private Long idVeiculo;

    private boolean ativo;

    private Double valor;

    private boolean contratoCredito;
    
}
