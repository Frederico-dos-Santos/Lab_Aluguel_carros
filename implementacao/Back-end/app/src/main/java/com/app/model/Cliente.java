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


}
