package com.orangeguinee.api_park_orange.controller;

import com.orangeguinee.api_park_orange.model.Marque;
import com.orangeguinee.api_park_orange.service.MarqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marques")
public class MarqueController {

    private final MarqueService marqueService;

    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @GetMapping
    public List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Long id) {
        return marqueService.getMarqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Marque createMarque(@RequestBody Marque marque) {
        return marqueService.saveMarque(marque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable Long id, @RequestBody Marque marque) {
        if (!marqueService.getMarqueById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        marque.setId(id);
        return ResponseEntity.ok(marqueService.saveMarque(marque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        if (!marqueService.getMarqueById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        marqueService.deleteMarque(id);
        return ResponseEntity.noContent().build();
    }
}
