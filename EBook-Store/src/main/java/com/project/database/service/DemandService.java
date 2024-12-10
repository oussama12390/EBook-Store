package com.project.database.service;

import com.project.database.entity.Demand;
import com.project.database.repository.BookRepository;
import com.project.database.repository.EmprunteurRepository;
import com.project.database.repository.DemandRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandService {

    private final BookRepository bookRepository;
    private final EmprunteurRepository emprunteurRepository;
    private final DemandRepository demandRepository;

    @Autowired
    public DemandService(BookRepository bookRepository, EmprunteurRepository emprunteurRepository, DemandRepository demandRepository) {
        this.bookRepository = bookRepository;
        this.emprunteurRepository = emprunteurRepository;
        this.demandRepository = demandRepository;
    }

    public Demand acceptDemand(String demandId) {
        Demand demand = demandRepository.findById(demandId).orElse(null);
        if (demand != null) {
            // Implement logic to handle accepting the demand
            // For example, set a flag indicating it's accepted and perform any other necessary operations
            // Then, save the updated demand
            demand.setAccepted(true);  // Add a field 'accepted' in the Demand entity
            return demandRepository.save(demand);
        }
        return null; // Handle case where demand with given id is not found
    }

    public void deleteDemand(String demandId) {
        // Implement logic to delete the demand
        demandRepository.deleteById(demandId);
    }

    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    public List<Demand> getAllDemandsWithDetails() {
        List<Demand> demands = demandRepository.findAllDemands();
        fetchDetails(demands);
        return demands;
    }

    private void fetchDetails(List<Demand> demands) {
        for (Demand demand : demands) {
            demand.setBookDemanded(bookRepository.findById(demand.getBookDemanded().getId()).orElse(null));
            demand.setEmprunteur(emprunteurRepository.findById(demand.getEmprunteur().getId()).orElse(null));
        }
    }

    public Demand getDemandById(String demandId) {
        return demandRepository.findById(demandId).orElse(null);
    }


    // public List<Demand> getAllDemandsWithDetails() {
    //     List<Demand> demands = demandRepository.findAllDemandsWithDetails();
    //     fetchDetails(demands);
    //     return demands;
    // }
    
    public List<Demand> findAllDemandsWithDetails() {
        return demandRepository.findAllDemandsWithDetails();
    }

    public Demand addDemand(Demand demand) {
        // You may want to set the demand date to the actual date here
        demand.setDemandDate(LocalDateTime.now());

        // You can perform additional validation or business logic before saving
        // Save the demand to the repository
        return demandRepository.save(demand);
    }
    
}
