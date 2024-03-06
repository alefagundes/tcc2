package com.alefagundes.tcc2.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http.csrf(csrf -> csrf.disable())
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //define para não salvar nenhum dado na sessão do usuário
               .authorizeHttpRequests((req) -> {
                req.requestMatchers(HttpMethod.POST, "/users/new").permitAll();
                req.requestMatchers(HttpMethod.POST, "/users/login").permitAll();
                req.anyRequest().authenticated();
               }).build();
    }
}