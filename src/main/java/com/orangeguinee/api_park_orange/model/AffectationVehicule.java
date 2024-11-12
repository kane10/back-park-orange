package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class AffectationVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;

    @ManyToOne
    private Demandeur demandeur; // Relation avec Demandeur pour l'affectation

    private Date dateAffectation;
    private Date dateRetour;
    private String typeAffectation; // Service ou fonction


}
