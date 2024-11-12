package com.orangeguinee.api_park_orange.controller;

import com.orangeguinee.api_park_orange.model.Vehicule;
import com.orangeguinee.api_park_orange.service.VehiculeService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("/list")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @GetMapping("/vehicule/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.saveVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        if (!vehiculeService.getVehiculeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setId(id);
        return ResponseEntity.ok(vehiculeService.saveVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        if (!vehiculeService.getVehiculeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.noContent().build();
    }

}
