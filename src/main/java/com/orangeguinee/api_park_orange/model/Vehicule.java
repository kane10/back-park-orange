package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Data
@Validated
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String immatriculation;

    private int annee;
    private String numeroChassis;
    private String type;
    private int kilometrage;
    private String etat;
    private String zone;
    private boolean disponibilite;

    @ManyToOne
    private Marque marque;  // Liste déroulante pour la marque

    @ManyToOne
    private Modele modele;  // Liste déroulante pour le modèle

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Entretien> entretiens;  // Liste des entretiens liés au véhicule

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;  // Liste des maintenances liées au véhicule


}
