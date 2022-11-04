package br.edu.unisep.tads.ifud.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.edu.unisep.tads.ifud.security.services.UsuarioDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    
    private static final Logger logger = 
        LoggerFactory.getLogger(JwtUtils.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private String generateJwtToken(Authentication authentication){

        UsuarioDetailsImpl usuarioPrincipal = (UsuarioDetailsImpl) 
            authentication.getPrincipal();
        return Jwts.builder()
            .setSubject(usuarioPrincipal.getUserName())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date()).getTime() + jwtExpirationMs)
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }
}
