package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByStatus(String status);
    boolean existsByPlate(String plate);
    boolean existsByChassisNumber(String chassisNumber);
}