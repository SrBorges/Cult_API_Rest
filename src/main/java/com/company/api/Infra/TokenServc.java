package com.company.api.Infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.company.api.Usuarios.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Service
public class TokenServc {


    @Value("api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioEntity json){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API com.company")
                    .withSubject(json.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){

            throw new RuntimeException("Erro ao gerar Token", exception);

        }

    }

    public String getSubject(String tokenJWT){

        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API com.company")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){

            throw new RuntimeException("Token Inválido");

        }

    }

private Instant dataExpiracao(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
}
}
