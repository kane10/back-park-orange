package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Demandeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;


}
