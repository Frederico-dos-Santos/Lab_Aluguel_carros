package com.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer ano;

    @Column
    private Integer matricula;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private String propietario;

    @Column
    private Boolean alugado;

}
