package com.project.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

// import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "demands")
public class Demand {

    @Id
    private String id;

    private LocalDateTime demandDate;

    @DBRef
    private Book bookDemanded;

    @DBRef
    private Emprunteur emprunteur;

    @DBRef
    private Reservation reservation;

    private boolean accepted; 

    public Demand() {
    }

    public Demand(String id, LocalDateTime demandDate, Book bookDemanded, Emprunteur emprunteur) {
        this.id = id;
        this.demandDate = demandDate;
        this.bookDemanded = bookDemanded;
        this.emprunteur = emprunteur;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

