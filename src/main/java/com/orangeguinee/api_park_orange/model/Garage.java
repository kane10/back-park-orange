package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;
    private String contact;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<Entretien> entretiens;  // Liste des entretiens effectués par ce garage

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;  // Liste des maintenances effectuées par ce garage

}
