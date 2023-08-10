package com.company.api.Clientes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "ClienteEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class ClienteEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String nome;
    private String rg;
    private String cpf;
    @NotNull @Email
    private String email;
    private String telefone;
    private String celular;
    @Embedded
    private Endereco endereco;

    public ClienteEntity(ClienteEntity json) {

        this.nome = json.nome;
        this.rg = json.rg;
        this.cpf = json.cpf;
        this.email = json.email;
        this.telefone = json.telefone;
        this.celular = json.celular;
        this.endereco = new Endereco(json.endereco);

    }

    public void updateInfo(CliUpdateDTO json) {

        if(json.nome() != null){
            this.nome = json.nome();
        }

        if(json.rg() != null){
            this.rg = json.rg();
        }

        if(json.cpf() != null){
            this.cpf = json.cpf();
        }

        if(json.email() != null){
            this.email = json.email();
        }

        if(json.celular() != null){
            this.celular = json.celular();
        }

        if(json.endereco() != null){
            this.endereco.novoEndereco(endereco);
        }

    }
}
