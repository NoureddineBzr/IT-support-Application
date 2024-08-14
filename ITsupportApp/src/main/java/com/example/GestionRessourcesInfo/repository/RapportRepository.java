package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport, Long> {
}
