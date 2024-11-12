package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    // Getters et setters
}
