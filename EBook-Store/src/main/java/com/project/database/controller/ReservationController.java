package com.project.database.controller;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.database.entity.Reservation;
import com.project.database.repository.ReservationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    
    
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/details")  
    public List<Reservation> getAllReservationsWithDetails() {
        return reservationRepository.findAllWithDetails();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    // @PostMapping
    // public Reservation addReservation(@RequestBody Reservation reservation) {
    //     return reservationRepository.save(reservation);
    // }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
    Reservation createdReservation = reservationRepository.save(reservation);
    
    // Fetch the detailed reservation with book information
    Reservation reservationWithDetails = reservationRepository.findByIdWithDetails(createdReservation.getId());

    return new ResponseEntity<>(reservationWithDetails, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation updatedReservation) {
        updatedReservation.setId(id);
        return reservationRepository.save(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationRepository.deleteById(id);
    }
}


