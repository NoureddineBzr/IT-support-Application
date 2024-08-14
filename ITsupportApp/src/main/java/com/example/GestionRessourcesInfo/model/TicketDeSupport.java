package com.example.GestionRessourcesInfo.model;

import com.example.GestionRessourcesInfo.model.enums.EtatTicket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketDeSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatTicket etat;
    private Date dateCreation;
    private Date dateResolution;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private TechnicienIT technicienIT;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;
}
