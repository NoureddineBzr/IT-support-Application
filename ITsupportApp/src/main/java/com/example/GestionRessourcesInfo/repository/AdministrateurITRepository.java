package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.AdministrateurIT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurITRepository extends JpaRepository<AdministrateurIT, Long> {
    Optional<AdministrateurIT> findByEmail(String email);
}
