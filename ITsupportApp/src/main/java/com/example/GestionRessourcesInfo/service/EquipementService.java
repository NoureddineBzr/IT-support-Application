package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.Equipement;
import com.example.GestionRessourcesInfo.repository.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    public Equipement creerEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}