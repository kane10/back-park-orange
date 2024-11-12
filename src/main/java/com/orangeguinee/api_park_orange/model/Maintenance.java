package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;


    private String typeMaintenance; // vidange, changement de pneus, etc.
    private Date date;
    private String description;
    private double cout;


}
