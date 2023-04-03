package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean ativo;

    @Column
    private Double valor;

    @Column
    private Boolean contratoCredito;

    @OneToOne
    private Veiculo veiculo;

    @ManyToOne
    private Cliente cliente;

    public Contrato(Boolean ativo, Double valor, Boolean contratoCredito, Veiculo veiculo, Cliente cliente) {
        this.ativo = ativo;
        this.valor = valor;
        this.contratoCredito = contratoCredito;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }



}
