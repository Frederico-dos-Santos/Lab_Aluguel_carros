package com.app.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_usuario")
public class Usuario {

    private String name;

    private String password;

    private String email;

}
