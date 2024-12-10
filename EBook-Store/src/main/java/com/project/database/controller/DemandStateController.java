package com.project.database.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.database.entity.DemandState;
import com.project.database.repository.DemandStateRepository;
// import com.project.database.service.DemandStateService;


@RestController
@RequestMapping("/api/demandsState")
public class DemandStateController {

    @Autowired
    private DemandStateRepository demandStateRepository;


    @GetMapping("/{demandStateId}")
     public DemandState getDemandStateById(String demandStateId) {
        return demandStateRepository.findById(demandStateId).orElse(null);
    }


    @DeleteMapping("/{demandStateId}")
    public void deleteDemandState(@PathVariable String demandStateId) {
    demandStateRepository.deleteById(demandStateId);
    }

    @GetMapping
    public List<DemandState> getAllDemandsState() {
        return demandStateRepository.findAll();
    }

    @PutMapping("/{demandStateId}")
    public DemandState updateDemandStateStatut(@PathVariable String demandStateId, @RequestBody Map<String, String> statutUpdate) {
    DemandState demandState = demandStateRepository.findById(demandStateId).orElse(null);
    if (demandState != null && statutUpdate.containsKey("statut")) {
        demandState.setStatut(statutUpdate.get("statut"));
        return demandStateRepository.save(demandState);
    }
    return null; // Handle case where demandState with given id is not found or statut parameter is missing
    }


    @PostMapping("/add")
    public DemandState addDemandState(DemandState demandState) {
        // You may want to set the demand date to the actual date here
        demandState.setBeginDateTime(LocalDateTime.now());
        LocalDateTime endDateTime = LocalDateTime.now().plus(1, ChronoUnit.WEEKS);
        demandState.setEndDateTime(endDateTime);
        demandState.setStatut("in progress");
        // You can perform additional validation or business logic before saving
        // Save the demand to the repository
        return demandStateRepository.save(demandState);
    }


    // private final  DemandStateService demandStateService;

    // @Autowired
    // public DemandStateController(DemandStateService demandStateService) {
    //     this.demandStateService = demandStateService;
    // }

    // @GetMapping
    // public List<DemandState> getAllDemandsState() {
    //     return demandStateService.getAllDemandsState();
    
    // }


    // @GetMapping("/{demandStateId}")
    // public DemandState getDemandById(@PathVariable String demandStateId) {
    //     return demandStateService.getDemandStateById(demandStateId);
    // }


    // @PostMapping("/add")
    // public DemandState addDemandState(@RequestBody DemandState demandState) {
    //     return demandStateService.addDemandState(demandState);
    // }

    // @DeleteMapping("/{demandStateId}")
    // public void deleteDemandState(@PathVariable String demandStateId) {
    //     demandStateService.deleteDemandState(demandStateId);
    // }
    
}
