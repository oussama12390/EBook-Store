package com.project.database.repository;

import com.project.database.entity.Demand;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DemandRepository extends MongoRepository<Demand, String> {

    @Query(value = "{}", fields = "{bookDemanded: 1, emprunteur: 1}")
    List<Demand> findAllDemands();

    @Query(value = "{'accepted' : ?0}")
    List<Demand> findAllDemandsWithDetails();


}

