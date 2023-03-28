package com.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Usuario{

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String endereco;

    @Column
    private String profissao;

    @Column
    private String entidadeEmpregadora;

    public Cliente(String name, String password, String email, String cpf, String rg, String endereco, String profissao,
                   String entidadeEmpregadora) {
        super(name, password, email);
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.profissao = profissao;
        this.entidadeEmpregadora = entidadeEmpregadora;
    }

    public String retornaCliente(){

        StringBuilder cliente = new StringBuilder();

        cliente.append(this.getName())
                .append(";")
                .append(this.getPassword())
                .append(";")
                .append(this.getEmail())
                .append(";")
                .append(this.getCpf())
                .append(";")
                .append(this.getRg())
                .append(";")
                .append(this.getEndereco())
                .append(";")
                .append(this.getProfissao())
                .append(";")
                .append(this.getEntidadeEmpregadora());

        return cliente.toString();

    }
}
