package com.orangeguinee.api_park_orange.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class InsuranceClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "accident_id", nullable = false)
    private com.orangeguinee.api_park_orange.model.Accident accident;

    @Column(nullable = false, unique = true)
    private String claimNumber;

    @Enumerated(EnumType.STRING)
    private com.orangeguinee.api_park_orange.model.InsuranceClaimStatus status;

    private Double amount;
    private String notes;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    private LocalDateTime updatedAt;
}