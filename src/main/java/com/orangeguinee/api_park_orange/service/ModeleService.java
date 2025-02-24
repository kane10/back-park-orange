package com.orangeguinee.api_park_orange.service;

import com.orangeguinee.api_park_orange.model.Modele;
import com.orangeguinee.api_park_orange.repository.ModeleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeleService {

    private final ModeleRepository modeleRepository;

    public ModeleService(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }

    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    public List<Modele> getModelesByMarqueId(Long marqueId) {
        return modeleRepository.findByMarqueId(marqueId);
    }

    public Optional<Modele> getModeleById(Long id) {
        return modeleRepository.findById(id);
    }

    public Modele saveModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }
}
