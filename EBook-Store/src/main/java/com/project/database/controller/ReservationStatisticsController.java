package com.project.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import com.project.database.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservations-statistics")
public class ReservationStatisticsController {

    @Autowired
    private ReservationRepository reservationRepository;
  
    @GetMapping
    public List<Map<String, Object>> getReservationStatistics() {
      // Assuming you want statistics for the default interval (e.g., 'month')
      return reservationRepository.customQuery();
    }
}

