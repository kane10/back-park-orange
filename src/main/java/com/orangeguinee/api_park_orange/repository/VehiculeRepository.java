package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.Vehicule;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

}
