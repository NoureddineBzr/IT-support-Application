package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
    Personne findByUsername(String username);
}
