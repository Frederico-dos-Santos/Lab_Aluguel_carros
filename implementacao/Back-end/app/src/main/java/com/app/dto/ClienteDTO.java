package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String name;

    private String password;

    private String email;

    private String cpf;

    private String rg;

    private String endereco;

    private String profissao;

    private String entidadeEmpregadora1;

    private Double salario1;

    private String entidadeEmpregadora2;

    private Double salario2;

    private String entidadeEmpregadora3;

    private Double salario3;


}
