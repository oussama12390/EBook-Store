package com.project.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.entity.Emprunteur;
import com.project.database.repository.EmprunteurRepository;
import java.util.List;

@Service
public class EmprunteurService {

    @Autowired
    private EmprunteurRepository EmprunteurRepository;

    public List<Emprunteur> getAllEmprunteurs() {
        return EmprunteurRepository.findAll();
    }

    public Emprunteur createEmprunteur(Emprunteur Emprunteur) {
        return EmprunteurRepository.save(Emprunteur);
    }

    public Emprunteur getEmprunteurById(String id) {
        return EmprunteurRepository.findById(id).orElse(null);
    }

    // Additional CRUD methods can be added as needed
}

