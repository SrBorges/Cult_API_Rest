package com.company.api.Livro;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/livros")
@SecurityRequirement(name = "bearer-key")

public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid LivroEntity json, UriComponentsBuilder UriBuilder){

        var livro = repository.save(new LivroEntity(json));

        var uri = UriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(new LivroDTO(livro));

    }


    @GetMapping
    public Page<LivroDTO> read(Pageable page){

        return repository.findAll(page).map(LivroDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid LivUpdateDTO json){

        var livro = repository.getReferenceById(json.id());

        livro.infoUpdate(json);

        return ResponseEntity.ok(new LivUpdateDTO(livro));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var livro = repository.getReferenceById(id);

        return ResponseEntity.ok(new LivUpdateDTO(livro));

    }

}
