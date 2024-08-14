package com.example.GestionRessourcesInfo.model;

import com.example.GestionRessourcesInfo.model.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@DiscriminatorValue("TECHNICIAN")
public class TechnicienIT extends Personne {

    @Enumerated(EnumType.STRING)
    private Role role = Role.TECHNICIAN;


    @OneToMany(mappedBy = "technicienIT")
    private List<TicketDeSupport> ticketsSupport;

    @OneToMany(mappedBy = "technicienIT")
    private List<Rapport> reports;
}
