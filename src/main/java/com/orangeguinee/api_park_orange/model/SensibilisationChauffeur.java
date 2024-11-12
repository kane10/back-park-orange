package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class SensibilisationChauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Chauffeur chauffeur;

    private Date date;
    private String description;


}
