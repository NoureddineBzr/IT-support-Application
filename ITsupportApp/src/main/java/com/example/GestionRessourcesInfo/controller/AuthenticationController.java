package com.example.GestionRessourcesInfo.controller;


import com.example.GestionRessourcesInfo.model.Personne;
import com.example.GestionRessourcesInfo.model.enums.Role;
import com.example.GestionRessourcesInfo.repository.PersonneRepository;
import com.example.GestionRessourcesInfo.security.JwtAuth;
import com.example.GestionRessourcesInfo.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin("http://localhost:4200")
@RestController

public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private PersonneRepository personneRepository;


    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Personne authenticationRequest) {
        System.out.println("//////////////////auuuuuthcon");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
         Personne personne = personneRepository.findByUsername(authenticationRequest.getUsername());
        Role role= personne.getRole();
        String token = JwtAuth.generateToken(authenticationRequest.getUsername(),role);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);

    }

}