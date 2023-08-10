package com.company.api.Livro;

import jakarta.validation.constraints.NotNull;

public record LivroDTO(@NotNull Long id,
                       String titulo,
                       String autor,
                       String formato,
                       String editor,
                       String ano,
                       String npaginas,
                       Codigo codigo) {

    public LivroDTO(LivroEntity json){

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
