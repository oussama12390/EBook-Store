package com.project.database.controller;

import com.project.database.entity.Book;
import com.project.database.entity.Demand;
import com.project.database.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demands")
public class DemandController {

    private final DemandService demandService;

    @Autowired
    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @GetMapping
    public List<Demand> getAllDemands() {
        return demandService.getAllDemands();
    
    }

    @GetMapping("/details")
    public List<Demand> getAllDemandsWithDetails() {
    List<Demand> demands = demandService.getAllDemandsWithDetails();
    return demands;
}


    // @GetMapping("/{demandId}")
    // public Demand getDemandById(@PathVariable String demandId) {
    //     return demandService.getDemandById(demandId);
    // }

    @GetMapping("/{demandId}")
public Demand getDemandById(@PathVariable String demandId) {
    Demand demand = demandService.getDemandById(demandId);

    // Fetch originalQuantity from the associated book
    if (demand != null && demand.getBookDemanded() != null) {
        Book book = demand.getBookDemanded();
        demand.getBookDemanded().setOriginalQuantity(book.getQuantite());
    }

    return demand;
}



    @PostMapping("/accept/{demandId}")
    public Demand acceptDemand(@PathVariable String demandId) {
        return demandService.acceptDemand(demandId);
    }

    @PostMapping("/add")
    public Demand addDemand(@RequestBody Demand demand) {
        return demandService.addDemand(demand);
    }

    @DeleteMapping("/{demandId}")
    public void deleteDemand(@PathVariable String demandId) {
        demandService.deleteDemand(demandId);
    }
}
