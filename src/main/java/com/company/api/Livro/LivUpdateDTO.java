package com.company.api.Livro;

import jakarta.validation.constraints.NotNull;

public record LivUpdateDTO(@NotNull Long id,
                           String titulo,
                           String autor,
                           String formato,
                           String editor,
                           String ano,
                           String npaginas,
                           Codigo codigo) {


    public LivUpdateDTO(LivroEntity json){

        this(json.getId(),
                json.getTitulo(),
                json.getAutor(),
                json.getFormato(),
                json.getEditor(),
                json.getAno(),
                json.getNpaginas(),
                json.getCodigo());

    }

}