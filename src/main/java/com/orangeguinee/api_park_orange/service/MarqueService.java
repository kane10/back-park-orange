package com.orangeguinee.api_park_orange.service;


import com.orangeguinee.api_park_orange.model.Marque;
import com.orangeguinee.api_park_orange.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {
    private final MarqueRepository marqueRepository;

    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Optional<Marque> getMarqueById(Long id) {
        return marqueRepository.findById(id);
    }

    public Marque saveMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }
}
