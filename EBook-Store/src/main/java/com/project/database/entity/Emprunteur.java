package com.project.database.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.database.controller.BookReserved;

@Data
@Getter
@Setter
@Document(collection = "emprunteurs")
public class Emprunteur {

    @Id
    private String id;
    private String username;
    private String address;
    private String sexe;
    private String telephone;
    private int age;
    private String cin;
    private String email;

    // @DBRef
    // private Book bookReserved;

    @DBRef 
    private BookReserved bookReserved;

    @DBRef
    private List<Reservation> reservations;
    
    public Emprunteur() {
    }

    public Emprunteur(String id, String username, String address, String sexe, String telephone, int age, String cin,
            String email) {
        super();
        this.id = id;
        this.username = username;
        this.address = address;
        this.sexe = sexe;
        this.telephone = telephone;
        this.age = age;
        this.cin = cin;
        this.email = email;
    }

    public Emprunteur(String id, String username) {
        this.id = id;
        this.username = username;
    }


}
