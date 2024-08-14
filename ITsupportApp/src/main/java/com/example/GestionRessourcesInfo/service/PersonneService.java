package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personnerepo;

}
