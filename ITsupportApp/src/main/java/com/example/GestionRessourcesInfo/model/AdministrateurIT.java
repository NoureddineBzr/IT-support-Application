package com.example.GestionRessourcesInfo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

    @Getter
    @Setter
    @Entity
    @DiscriminatorValue("ADMIN")
    public class AdministrateurIT extends Personne {

        @OneToMany(mappedBy = "administrateurIT")
        private List<Rapport> reports;

        @OneToMany(mappedBy = "administrateurIT")
        private List<Notification> notifications;
    }
