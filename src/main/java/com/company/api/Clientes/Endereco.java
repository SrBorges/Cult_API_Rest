package com.company.api.Clientes;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {

    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(Endereco endereco) {

        this.rua = endereco.rua;
        this.bairro = endereco.bairro;
        this.cep = endereco.cep;
        this.cidade = endereco.cidade;
        this.estado = endereco.estado;

    }


    public void novoEndereco(Endereco endereco) {

        if(endereco.rua != null){
            this.rua = endereco.rua;
        }

        if(endereco.bairro != null){
            this.bairro = endereco.bairro;
        }

        if(endereco.cep != null){
            this.cep = endereco.cep;
        }

        if(endereco.cidade != null){
            this.cidade = endereco.cidade;
        }

        if(endereco.estado != null){
            this.estado = endereco.estado;
        }

    }
}
