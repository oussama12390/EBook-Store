package com.project.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.database.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}

