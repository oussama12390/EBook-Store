package com.project.database.entity;

import lombok.Data;

// import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;

    @DBRef
    private Book book;

    @DBRef
    private Emprunteur emprunteur;

    // private String bookId;
    // private String emprunteurId;
    private LocalDateTime reservationDate;

    public Reservation() {
    }

    public Reservation(String id, Book book, Emprunteur emprunteur, LocalDateTime reservationDate) {
        this.id = id;
        this.book = book;
        this.emprunteur = emprunteur;
        this.reservationDate = reservationDate;
    }
}
