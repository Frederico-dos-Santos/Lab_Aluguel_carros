package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{

    private String cpf;
    private String rg;
    private String endereco;
    private String profissao;
    private String entidadeEmpregadora;
    private Double[] rendimentos;
    private List<Contrato> contratos;

    public Cliente(String cpf, String rg, String endereco, String profissao, String entidadeEmpregadora) {
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.profissao = profissao;
        this.entidadeEmpregadora = entidadeEmpregadora;
        this.rendimentos = new Double[3];
        this.contratos = new ArrayList<>();
    }

    public Contrato pedirAluguel(Double valor, Veiculo veiculo){
        return null;
    }

    public void modificarValorAluguel(Integer id, Double valor){

    }

    public void modificarVeiculoAluguel(Integer id, Veiculo veiculo){

    }

    public Contrato cancelarAluguel(Integer id){

        return null;
    }

    public Contrato buscarAluguel(Integer id){

        return null;
    }
}
