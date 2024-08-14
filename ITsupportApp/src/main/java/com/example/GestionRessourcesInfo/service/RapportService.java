package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.Rapport;
import com.example.GestionRessourcesInfo.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    public Rapport creerRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    public Rapport getRapportById(Long id) {
        return rapportRepository.findById(id).orElse(null);
    }

    public Rapport updateRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }
}