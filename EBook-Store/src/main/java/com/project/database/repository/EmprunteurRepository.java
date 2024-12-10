package com.project.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.database.entity.Emprunteur;

public interface EmprunteurRepository extends MongoRepository<Emprunteur, String> {
    // Custom queries or methods can be added here
}
