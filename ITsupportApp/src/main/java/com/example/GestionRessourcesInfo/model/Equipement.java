package com.example.GestionRessourcesInfo.model;

import com.example.GestionRessourcesInfo.model.enums.EtatEquipement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatEquipement etat;
    private Date dateAcquisition;

    @OneToMany(mappedBy = "equipement")
    private List<Panne> pannes;

}
