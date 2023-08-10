package com.company.api.Clientes;

import jakarta.validation.constraints.NotNull;

public record ClienteDTO(@NotNull Long id,
                         String nome,
                         String rg,
                         String cpf,
                         String email,
                         String celular,
                         Endereco endereco) {

    public ClienteDTO(ClienteEntity json){
        this(json.getId(),
                json.getNome(),
                json.getRg(),
                json.getCpf(),
                json.getEmail(),
                json.getCelular(),
                json.getEndereco());
    }

}
