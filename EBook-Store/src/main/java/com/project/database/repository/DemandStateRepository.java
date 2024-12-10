package com.project.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.database.entity.DemandState;

public interface DemandStateRepository extends MongoRepository<DemandState, String>{
    
}
