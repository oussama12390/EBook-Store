package com.project.database.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "bookReserved")
@Getter
@Setter
public class BookReserved {
    
    @Id
    private String id;
    private String title;

}

