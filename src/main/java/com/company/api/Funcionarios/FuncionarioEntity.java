package com.company.api.Funcionarios;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "funcionarios")
@Entity(name = "FuncionarioEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class FuncionarioEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String nome;
    private String idade;
    private String cpf;
    private String dnascimento;
    private double salario;
    @Enumerated(EnumType.STRING)
    private Funcao funcao;


    public FuncionarioEntity(FuncionarioEntity json) {

        this.nome = json.nome;
        this.idade = json.idade;
        this.cpf = json.cpf;
        this.dnascimento = json.dnascimento;
        this.salario = json.salario;
        this.funcao = json.funcao;

    }


    public void updateInfo(FuncUpdateDTO json) {

        if(json.nome() != null){
            this.nome = json.nome();
        }
        if(json.idade() != null){
            this.idade = json.idade();
        }

        if(json.cpf() != null){
            this.cpf = json.cpf();
        }

        if(json.dnascimento() != null){
            this.dnascimento = json.dnascimento();
        }

        if(json.funcao() != null){
            this.funcao = json.funcao();
        }

    }
}
