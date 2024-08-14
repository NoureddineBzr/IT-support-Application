package com.example.GestionRessourcesInfo.model;

import com.example.GestionRessourcesInfo.model.enums.TypeRapport;
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
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeRapport type;
    private Date dateGeneration;
    @Lob
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "administrateurIT_id")
    private AdministrateurIT administrateurIT;

    @ManyToOne
    @JoinColumn(name = "technicienIT_id")
    private TechnicienIT technicienIT;

}