package com.orangeguinee.api_park_orange.service;


import com.orangeguinee.api_park_orange.model.AffectationVehicule;
import com.orangeguinee.api_park_orange.model.Demandeur;
import com.orangeguinee.api_park_orange.model.Vehicule;
import com.orangeguinee.api_park_orange.repository.AffectationVehiculeRepository;
import com.orangeguinee.api_park_orange.repository.DemandeurRepository;
import com.orangeguinee.api_park_orange.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AffectationVehiculeService {


    private final VehiculeRepository vehiculeRepository;

    private final DemandeurRepository demandeurRepository;

    private final AffectationVehiculeRepository affectationVehiculeRepository;

    public AffectationVehiculeService(VehiculeRepository vehiculeRepository, DemandeurRepository demandeurRepository, AffectationVehiculeRepository affectationVehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.demandeurRepository = demandeurRepository;
        this.affectationVehiculeRepository = affectationVehiculeRepository;
    }

    public Optional<AffectationVehicule> affecterVehicule(Long vehiculeId, Long demandeurId, Date dateRetourPrevue) {
        Optional<Vehicule> vehiculeOpt = vehiculeRepository.findById(vehiculeId);
        Optional<Demandeur> demandeurOpt = demandeurRepository.findById(demandeurId);

        if (vehiculeOpt.isPresent() && demandeurOpt.isPresent()) {
            AffectationVehicule affectation = new AffectationVehicule();
            affectation.setVehicule(vehiculeOpt.get());
            affectation.setDemandeur(demandeurOpt.get());
            affectation.setDateAffectation(new Date());  // Date actuelle comme date d'affectation
           // affectation.setDateRetourPrevue(dateRetourPrevue);

            return Optional.of(affectationVehiculeRepository.save(affectation));
        } else {
            return Optional.empty();  // Retourne vide si le véhicule ou le demandeur n'est pas trouvé
        }
    }
}
