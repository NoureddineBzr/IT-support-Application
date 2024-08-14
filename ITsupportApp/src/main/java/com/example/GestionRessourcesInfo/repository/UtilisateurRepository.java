package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}