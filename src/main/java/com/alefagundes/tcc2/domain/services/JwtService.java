package com.alefagundes.tcc2.domain.services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtEncoder encoder;

    public String generateToken(Authentication authentication){
        Instant now = Instant.now();
        long expiry = 3600L; //defino um tempo de uma hora para expirar o meu token

        String scopes = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        //scopos que são as permissões do usuário (leitura, escrita etc..)

        var claims = JwtClaimsSet.builder()
        .issuer("spring-security-jwt")
        .issuedAt(now)
        .expiresAt(now.plusSeconds(expiry))
        .subject(authentication.getName())
        .claim("scopes", scopes)
        .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    
}