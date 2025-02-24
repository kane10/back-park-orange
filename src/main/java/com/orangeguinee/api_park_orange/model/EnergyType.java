package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EnergyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}