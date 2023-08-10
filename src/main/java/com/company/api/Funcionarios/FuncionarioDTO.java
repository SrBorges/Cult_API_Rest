package com.company.api.Funcionarios;

import jakarta.validation.constraints.NotNull;

public record FuncionarioDTO(@NotNull Long id,
                             String nome,
                             String idade,
                             String cpf,
                             String dNascimento,
                             double salario,
                             Funcao funcao) {

    public FuncionarioDTO(FuncionarioEntity json){

        this(json.getId(),
                json.getNome(),
                json.getIdade(),
                json.getCpf(),
                json.getDnascimento(),
                json.getSalario(),
                json.getFuncao());

    }
}
