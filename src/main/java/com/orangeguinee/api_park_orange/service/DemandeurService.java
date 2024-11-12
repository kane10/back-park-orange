package com.orangeguinee.api_park_orange.service;

import com.orangeguinee.api_park_orange.model.Demandeur;
import com.orangeguinee.api_park_orange.repository.DemandeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeurService {

    private final DemandeurRepository demandeurRepository;

    public DemandeurService(DemandeurRepository demandeurRepository) {
        this.demandeurRepository = demandeurRepository;
    }

    public List<Demandeur> getAllDemandeurs() {
        return demandeurRepository.findAll();
    }

    public Optional<Demandeur> getDemandeurById(Long id) {
        return demandeurRepository.findById(id);
    }

    public Demandeur saveDemandeur(Demandeur demandeur) {
        return demandeurRepository.save(demandeur);
    }

    public void deleteDemandeur(Long id) {
        demandeurRepository.deleteById(id);
    }

    public Demandeur updateDemandeur(Demandeur demandeur) {
        return demandeurRepository.save(demandeur);
    }
}
