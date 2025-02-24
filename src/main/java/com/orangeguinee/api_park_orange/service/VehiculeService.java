package com.orangeguinee.api_park_orange.service;

import com.orangeguinee.api_park_orange.model.Vehicule;
import com.orangeguinee.api_park_orange.repository.VehiculeRepository;
import com.orange.parkroulant.exception.ResourceNotFoundException;
import com.orange.parkroulant.exception.DuplicateResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicule not found with id: " + id));
    }

    public Vehicule createVehicule(Vehicule vehicule) {
        if (vehiculeRepository.existsByPlate(vehicule.getPlate())) {
            throw new DuplicateResourceException("A vehicle with this plate number already exists");
        }
        if (vehiculeRepository.existsByChassisNumber(vehicule.getChassisNumber())) {
            throw new DuplicateResourceException("A vehicle with this chassis number already exists");
        }
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule updateVehicule(Long id, Vehicule vehiculeDetails) {
        Vehicule vehicule = getVehiculeById(id);

        // Vérifier si le nouveau numéro de plaque existe déjà pour un autre véhicule
        if (!vehicule.getPlate().equals(vehiculeDetails.getPlate()) &&
            vehiculeRepository.existsByPlate(vehiculeDetails.getPlate())) {
            throw new DuplicateResourceException("A vehicle with this plate number already exists");
        }

        // Vérifier si le nouveau numéro de châssis existe déjà pour un autre véhicule
        if (!vehicule.getChassisNumber().equals(vehiculeDetails.getChassisNumber()) &&
            vehiculeRepository.existsByChassisNumber(vehiculeDetails.getChassisNumber())) {
            throw new DuplicateResourceException("A vehicle with this chassis number already exists");
        }

        vehicule.setModel(vehiculeDetails.getModel());
        vehicule.setPlate(vehiculeDetails.getPlate());
        vehicule.setType(vehiculeDetails.getType());
        vehicule.setStatus(vehiculeDetails.getStatus());
        vehicule.setChassisNumber(vehiculeDetails.getChassisNumber());
        vehicule.setColor(vehiculeDetails.getColor());
        vehicule.setPower(vehiculeDetails.getPower());
        vehicule.setEnergy(vehiculeDetails.getEnergyType());
        vehicule.setServiceDate(vehiculeDetails.getServiceDate());
        vehicule.setAge(vehiculeDetails.getAge());
        vehicule.setAssignmentZone(vehiculeDetails.getAssignmentZone());
        vehicule.setResponsibleDriver(vehiculeDetails.getResponsibleDriver());
        vehicule.setDepartment(vehiculeDetails.getDepartment());
       /* vehicule.setLastMaintenanceDate(vehiculeDetails.getLastMaintenanceDate());
        vehicule.setLastMaintenanceMileage(vehiculeDetails.getLastMaintenanceMileage());*/
        vehicule.setCurrentMileage(vehiculeDetails.getCurrentMileage());
        vehicule.setDealer(vehiculeDetails.getDealer());
        vehicule.setPurchasePrice(vehiculeDetails.getPurchasePrice());

        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        Vehicule vehicule = getVehiculeById(id);
        vehiculeRepository.delete(vehicule);
    }

    public List<Vehicule> getVehiculesByStatus(String status) {
        return vehiculeRepository.findByStatus(status);
    }
}