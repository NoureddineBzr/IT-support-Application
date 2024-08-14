package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.Panne;
import com.example.GestionRessourcesInfo.repository.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService {

    @Autowired
    private PanneRepository panneRepository;

    public Panne creerPanne(Panne panne) {
        return panneRepository.save(panne);
    }

    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    public Panne getPanneById(Long id) {
        return panneRepository.findById(id).orElse(null);
    }

    public Panne updatePanne(Panne panne) {
        return panneRepository.save(panne);
    }

    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }
}