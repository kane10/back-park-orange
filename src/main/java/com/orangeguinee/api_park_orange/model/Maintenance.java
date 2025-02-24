package com.orangeguinee.api_park_orange.model;

import com.orangeguinee.api_park_orange.model.MaintenanceProvider;
import com.orangeguinee.api_park_orange.model.MaintenanceType;
import com.orangeguinee.api_park_orange.model.Vehicule;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MaintenanceType type;

    private String description;
    private Double cost;
    private Integer mileage;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private MaintenanceProvider provider;

    private LocalDate nextMaintenanceDate;
    private Integer nextMaintenanceMileage;
}