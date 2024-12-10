package com.project.database.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.database.entity.DemandState;
import com.project.database.repository.DemandStateRepository;

public class DemandStateService {

    @Autowired
    private DemandStateRepository demandStateRepository;

     @Autowired
    public DemandStateService(DemandStateRepository demandStateRepository) {
        this.demandStateRepository=demandStateRepository;
    }



    public DemandState getDemandStateById(String demandId) {
        return demandStateRepository.findById(demandId).orElse(null);
    }

    public void deleteDemandState(String demandId) {
    
        demandStateRepository.deleteById(demandId);
    }

    public List<DemandState> getAllDemandsState() {
        return demandStateRepository.findAll();
    }

    public DemandState addDemandState(DemandState demandState) {
        // You may want to set the demand date to the actual date here
        demandState.setBeginDateTime(LocalDateTime.now());
        demandState.setEndDateTime(LocalDateTime.now());
        // You can perform additional validation or business logic before saving
        // Save the demand to the repository
        return demandStateRepository.save(demandState);
    }
    
}
