package com.alefagundes.tcc2.api.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.alefagundes.tcc2.domain.services.JwtService;

@Service
public class AuthenticationService {
  private JwtService jwtService;

  public AuthenticationService(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  public String authenticate(Authentication authentication) {
    return jwtService.generateToken(authentication);
  }
}