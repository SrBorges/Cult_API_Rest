package com.company.api.Funcionarios;

import jakarta.validation.constraints.NotNull;

public record FuncUpdateDTO(@NotNull Long id,
                            String nome,
                            String idade,
                            String cpf,
                            String dnascimento,
                            double salario,
                            Funcao funcao) {

    public FuncUpdateDTO(FuncionarioEntity json){

        this(json.getId(),
                json.getNome(),
                json.getIdade(),
                json.getCpf(),
                json.getDnascimento(),
                json.getSalario(),
                json.getFuncao());

    }

}
