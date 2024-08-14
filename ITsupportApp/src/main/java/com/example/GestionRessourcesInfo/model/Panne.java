package com.example.GestionRessourcesInfo.model;

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
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date datePanne;
    private boolean resolu;


    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    @OneToMany(mappedBy = "panne")
    private List<TicketDeSupport> tickets;
}