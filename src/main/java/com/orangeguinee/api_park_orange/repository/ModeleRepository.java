package com.orangeguinee.api_park_orange.repository;

import com.orangeguinee.api_park_orange.model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele, Long> {
    List<Modele> findByMarqueId(Long marqueId);
}
