package com.company.api.Usuarios;

import com.company.api.Infra.DadosTokenJWT;
import com.company.api.Infra.TokenServc;
import com.company.api.Usuarios.CheckDTO;
import com.company.api.Usuarios.UsuarioEntity;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/login")
@SecurityRequirement(name = "bearer-key")

public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenServc tokenServc;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid CheckDTO json){

        var authenticationToken = new UsernamePasswordAuthenticationToken(json.login(), json.password());

        var auth = manager.authenticate(authenticationToken);

        var tokenJWT = tokenServc.gerarToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }

}
