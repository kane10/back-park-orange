package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne
    private Chauffeur chauffeur;

    private Date dateAccident;
    private String description;
    private String rapport;

}
