package com.orangeguinee.api_park_orange.controller;



import com.orangeguinee.api_park_orange.model.Vehicule;
import com.orangeguinee.api_park_orange.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@CrossOrigin(origins = "http://localhost:5173") // Pour le développement avec Vite
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }

    @PostMapping
    public Vehicule createVehicule(@Valid @RequestBody Vehicule vehicule) {
        return vehiculeService.createVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @Valid @RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(id, vehicule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status/{status}")
    public List<Vehicule> getVehiculesByStatus(@PathVariable String status) {
        return vehiculeService.getVehiculesByStatus(status);
    }
}