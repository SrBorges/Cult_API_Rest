package com.company.api.Clientes;

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

@RequestMapping("/clientes")
@SecurityRequirement(name = "bearer-key")

public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ClienteEntity json, UriComponentsBuilder UriBuilder){

        var cliente = repository.save(new ClienteEntity(json));

        var uri = UriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));


    }

    @GetMapping
    public Page<ClienteDTO> read(Pageable page){

        return repository.findAll(page).map(ClienteDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid CliUpdateDTO json){

        var cliente = repository.getReferenceById(json.id());

        cliente.updateInfo(json);

        return ResponseEntity.ok(new CliUpdateDTO(cliente));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new ClienteDTO(cliente));

    }


}
