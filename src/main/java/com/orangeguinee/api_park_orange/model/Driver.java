package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String matricule;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    private String licenseType;
    private LocalDate licenseExpiryDate;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    private LocalDate joinDate;

    @OneToMany(mappedBy = "driver")
    private List<com.orangeguinee.api_park_orange.model.Reservation> reservations;

    @Enumerated(EnumType.STRING)
    private com.orangeguinee.api_park_orange.model.DriverStatus status;
}