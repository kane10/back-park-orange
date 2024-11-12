package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class DemandeVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;

    @ManyToOne
    private Demandeur demandeur; // Relation avec l'entité Demandeur


    private Date dateDemande;
    private Date dateReservation;
    private String mission;

    @Enumerated(EnumType.STRING)
    private DemandeStatut status;  // Utilisation de l'enum pour le statut



}
