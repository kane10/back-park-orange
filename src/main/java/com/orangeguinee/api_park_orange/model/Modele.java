package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    private Marque marque; // Association avec Marque pour filtrer les modèles par marque

    // Getters et setters
}
