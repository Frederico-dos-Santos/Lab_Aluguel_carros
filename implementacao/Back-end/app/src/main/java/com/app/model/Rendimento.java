package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tb_rendimento")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double valor;

    @ManyToOne
    private Cliente cliente;

    public Rendimento(Double valor, Cliente cliente) {
        this.valor = valor;
        this.cliente = cliente;
    }
}
