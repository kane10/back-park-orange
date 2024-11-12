package com.orangeguinee.api_park_orange.controller;

import com.orangeguinee.api_park_orange.model.Demandeur;
import com.orangeguinee.api_park_orange.service.DemandeurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandeurs")
public class DemandeurController {

    private final DemandeurService demandeurService;

    public DemandeurController(DemandeurService demandeurService) {
        this.demandeurService = demandeurService;
    }

    @GetMapping
    public List<Demandeur> getAllDemandeurs() {
        return demandeurService.getAllDemandeurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demandeur> getDemandeurById(@PathVariable Long id) {
        return demandeurService.getDemandeurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/nouveau")
    public Demandeur createDemandeur(@RequestBody Demandeur demandeur) {
        return demandeurService.saveDemandeur(demandeur);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Demandeur> updateDemandeur(@PathVariable Long id, @RequestBody Demandeur demandeur) {
        if (!demandeurService.getDemandeurById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        demandeur.setId(id);
        return ResponseEntity.ok(demandeurService.saveDemandeur(demandeur));
    }

    @DeleteMapping("/suprimer/{id}")
    public ResponseEntity<Void> deleteDemandeur(@PathVariable Long id) {
        if (!demandeurService.getDemandeurById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        demandeurService.deleteDemandeur(id);
        return ResponseEntity.noContent().build();
    }
}
