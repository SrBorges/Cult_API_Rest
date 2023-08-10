package com.company.api.Livro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "livro")
@Entity(name = "LivroEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class LivroEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String titulo;
    private String autor;
    private String formato;
    private String editor;
    private String ano;
    private String npaginas;
    @Enumerated(EnumType.STRING)
    private Codigo codigo;


    public LivroEntity(LivroEntity json) {

        this.titulo = json.titulo;
        this.autor = json.autor;
        this.formato = json.formato;
        this.editor = json.editor;
        this.ano = json.ano;
        this.npaginas = json.npaginas;
        this.codigo = json.codigo;

    }

    public void infoUpdate(LivUpdateDTO json) {

        if(json.titulo() != null){
            this.titulo = json.titulo();
        }

        if(json.autor() != null){
            this.autor = json.autor();
        }

        if(json.formato() != null){
            this.formato = json.formato();
        }

        if(json.editor() != null){
            this.editor = json.editor();
        }

        if(json.ano() != null){
            this.ano = json.ano();
        }

        if(json.npaginas() != null){
            this.npaginas = json.npaginas();
        }

        if(json.codigo() != null){
            this.codigo = json.codigo();
        }

    }
}
