package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MaintenanceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;
    private String phone;
    private String email;
    private String specialties;
}