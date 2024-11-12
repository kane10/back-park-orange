package com.orangeguinee.api_park_orange.service;


import com.orangeguinee.api_park_orange.model.Vehicule;
import com.orangeguinee.api_park_orange.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Optional<Vehicule> getVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }


}
