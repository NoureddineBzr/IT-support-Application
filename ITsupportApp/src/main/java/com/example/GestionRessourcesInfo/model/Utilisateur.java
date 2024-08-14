package com.example.GestionRessourcesInfo.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("User")
public class Utilisateur extends Personne {


    @OneToMany(mappedBy = "utilisateur")
    private List<TicketDeSupport> ticketsSupport;
}