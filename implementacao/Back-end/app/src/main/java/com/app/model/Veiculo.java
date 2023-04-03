package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column
    private String placa;

}
