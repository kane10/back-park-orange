package com.orangeguinee.api_park_orange.model;

import com.orangeguinee.api_park_orange.model.AccidentSeverity;
import com.orangeguinee.api_park_orange.model.Driver;
import com.orangeguinee.api_park_orange.model.InsuranceClaim;
import com.orangeguinee.api_park_orange.model.Vehicule;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private AccidentSeverity severity;

    private String damageDescription;
    private Double estimatedCost;

    @OneToOne(mappedBy = "accident", cascade = CascadeType.ALL)
    private InsuranceClaim insuranceClaim;
}