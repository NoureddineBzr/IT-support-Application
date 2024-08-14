package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}