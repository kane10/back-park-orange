package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;

    @Enumerated(EnumType.STRING)
    private TypeEntretien typeEntretien;

    private String description;
    private Date dateEntretien;
    private double cout;

    @ManyToOne
    private Garage garage;

}
