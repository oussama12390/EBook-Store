package com.project.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.database.entity.Emprunteur;
import com.project.database.repository.EmprunteurRepository;

import java.util.List;

@RestController
@RequestMapping("/api/emprunteurs")

public class EmprunteurController {


    @Autowired
    private EmprunteurRepository emprunteurRepository;

    @GetMapping
    public List<Emprunteur> getAllEmprunteurs() {
        return emprunteurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Emprunteur getEmprunteurById(@PathVariable String id) {
        return emprunteurRepository.findById(id).orElse(null);
    }

    // @PostMapping
    // public Emprunteur addEmprunteur(@RequestBody Emprunteur Emprunteur) {
    //     return emprunteurRepository.save(Emprunteur);
    // }

    @PostMapping
    public Emprunteur addEmprunteur(@RequestBody EmprunteurRequest emprunteurRequest) {
    try {
        Emprunteur emprunteur = new Emprunteur();
        emprunteur.setUsername(emprunteurRequest.getUsername());
        emprunteur.setTelephone(emprunteurRequest.getTelephone());
        emprunteur.setAge(emprunteurRequest.getAge());
        emprunteur.setCin(emprunteurRequest.getCin());
        emprunteur.setEmail(emprunteurRequest.getEmail());

        // Set the bookReserved field
        if (emprunteurRequest.getBookReserved() != null) {
            BookReserved bookReserved = new BookReserved();
            bookReserved.setId(emprunteurRequest.getBookReserved().getId());
            bookReserved.setTitle(emprunteurRequest.getBookReserved().getTitle());
            emprunteur.setBookReserved(bookReserved);
        }

        return emprunteurRepository.save(emprunteur);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error adding emprunteur", e);
    }
}



    @PutMapping("/{id}")
    public Emprunteur updateEmprunteur(@PathVariable String id, @RequestBody Emprunteur updatedEmprunteur) {
        updatedEmprunteur.setId(id);
        return emprunteurRepository.save(updatedEmprunteur);
    }

    @DeleteMapping("/{id}")
    public void deleteEmprunteur(@PathVariable String id) {
        emprunteurRepository.deleteById(id);
    }
}

    
