package com.example.GestionRessourcesInfo.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass

public class UtilisateurDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}