package com.project.database.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Document(collection = "demandstate")
public class DemandState {
    @Id
    private String id;
    private String statut;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    @DBRef
    private Book book;

    public DemandState() {
    }

    public DemandState(String id, String statut, LocalDateTime beginDateTime, LocalDateTime endDateTime, Book book) {
        this.id = id;
        this.statut = statut;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.book = book;
    }

    
    
}
