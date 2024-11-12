package com.orangeguinee.api_park_orange.controller;

import com.orangeguinee.api_park_orange.model.Modele;
import com.orangeguinee.api_park_orange.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modeles")
public class ModeleController {

    private final ModeleService modeleService;

    public ModeleController(ModeleService modeleService) {
        this.modeleService = modeleService;
    }

    @GetMapping
    public List<Modele> getAllModeles() {
        return modeleService.getAllModeles();
    }

    @GetMapping("/marque/{marqueId}")
    public List<Modele> getModelesByMarqueId(@PathVariable Long marqueId) {
        return modeleService.getModelesByMarqueId(marqueId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> getModeleById(@PathVariable Long id) {
        return modeleService.getModeleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Modele createModele(@RequestBody Modele modele) {
        return modeleService.saveModele(modele);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modele> updateModele(@PathVariable Long id, @RequestBody Modele modele) {
        if (!modeleService.getModeleById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modele.setId(id);
        return ResponseEntity.ok(modeleService.saveModele(modele));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModele(@PathVariable Long id) {
        if (!modeleService.getModeleById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modeleService.deleteModele(id);
        return ResponseEntity.noContent().build();
    }
}
