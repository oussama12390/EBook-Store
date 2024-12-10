package com.project.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.project.database.entity.Book;
// import com.project.database.entity.Emprunteur;
import com.project.database.entity.Reservation;
// import com.project.database.repository.BookRepository;
// import com.project.database.repository.EmprunteurRepository;
import com.project.database.repository.ReservationRepository;
// import com.project.database.dto.ReservationDetailsDTO;
import java.util.List;
import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.Optional;


@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public List<Map<String, Object>> getCustomQueryResult() {
        return reservationRepository.customQuery();
    }

    // @Autowired
    // private BookRepository bookRepository;

    // @Autowired
    // private EmprunteurRepository emprunteurRepository;

    // public List<ReservationDetailsDTO> getAllReservationDetails() {
    //     List<Reservation> reservations = reservationRepository.findAll();

    //     return reservations.stream()
    //             .map(this::mapToReservationDetailsDTO)
    //             .collect(Collectors.toList());
    // }

    // private ReservationDetailsDTO mapToReservationDetailsDTO(Reservation reservation) {
    //     Optional<Book> optionalBook = bookRepository.findById(reservation.getBookId());
    //     Optional<Emprunteur> optionalEmprunteur = emprunteurRepository.findById(reservation.getEmprunteurId());

    //     if (optionalBook.isPresent() && optionalEmprunteur.isPresent()) {
    //         Book reservedBook = optionalBook.get();
    //         Emprunteur emprunteur = optionalEmprunteur.get();

    //         return new ReservationDetailsDTO(reservation, reservedBook, emprunteur);
    //     } else {
    //         // Handle the case when either the book or emprunteur is not found
    //         // You can throw an exception or handle it according to your business logic
    //         return null;
    //     }
    //}
}

