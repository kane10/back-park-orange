package com.orangeguinee.api_park_orange.controller;

import com.orangeguinee.api_park_orange.model.AffectationVehicule;
import com.orangeguinee.api_park_orange.service.AffectationVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/affectations")
public class AffectationVehiculeController {

    @Autowired
    private AffectationVehiculeService affectationVehiculeService;

    @PostMapping("/affecter")
    public ResponseEntity<AffectationVehicule> affecterVehicule(
            @RequestParam Long vehiculeId,
            @RequestParam Long demandeurId,
            @RequestParam(required = false) Date dateRetourPrevue) {

        Optional<AffectationVehicule> affectation = affectationVehiculeService.affecterVehicule(vehiculeId, demandeurId, dateRetourPrevue);

        return affectation
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
