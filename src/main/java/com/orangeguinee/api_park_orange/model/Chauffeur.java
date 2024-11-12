package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "chauffeur")
    private List<Accident> accidents;


    private String nom;
    private String prenom;
    private String NumpermisConduire;
    private String dateNaissance;
    private String contact;

}
