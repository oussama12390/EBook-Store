package com.project.database.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmprunteurRequest {
    private String username;
    private String telephone;
    private int age;
    private String cin;
    private String email;
    private BookReserved bookReserved;

    // getters and setters
}
