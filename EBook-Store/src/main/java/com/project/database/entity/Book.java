package com.project.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private int quantite;
    private String genre;
    private String imageUrl;
    private boolean reserved;

    public Book() {
    }
    

    public Book(String id, String title, String author, String isbn, String description, int quantite, String genre,
            String imageUrl, boolean reserved) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.quantite = quantite;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.reserved=reserved;
    }
    public Book(String id) {
        this.id = id;
        this.title = ""; // Replace with actual default value
        this.author = ""; // Replace with actual default value
    }
    // other book details, e.g., publication year, genre, etc.

    private int originalQuantity;

    // existing methods

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity + 1;
    }
}

