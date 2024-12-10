package com.project.database.dto;


import com.project.database.entity.Reservation;
import com.project.database.entity.Book;
import com.project.database.entity.Emprunteur;

public class ReservationDetailsDTO {

    private Reservation reservation;
    private Book reservedBook;
    private Emprunteur emprunteur;

    public ReservationDetailsDTO(Reservation reservation, Book reservedBook, Emprunteur emprunteur) {
        this.reservation = reservation;
        this.reservedBook = reservedBook;
        this.emprunteur = emprunteur;
    }

    // Getters and setters

    // You can also add additional methods or fields if needed
}
