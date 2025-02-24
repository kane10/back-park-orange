package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private String plate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private VehiculeType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehiculeStatus status;

    @Column(nullable = false, unique = true)
    private String chassisNumber;

    private String color;
    private Integer power;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "energy_type_id", nullable = false)
    private EnergyType energyType;

    @Column(nullable = false)
    private LocalDate serviceDate;

    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone assignmentZone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver responsibleDriver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Maintenance> maintenanceHistory;

    private Integer currentMileage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    private Double purchasePrice;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Accident> accidents;

    public void setEnergy(EnergyType energyType) {
    }
}