package com.project.database.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.database.entity.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

    @Query(value = "{ $group: { _id: { $dateToString: { format: '%Y-%m', date: '$reservationDate' } }, count: { $sum: 1 } } }")
    List<Map<String, Object>> customQuery();


    @Query(value = "{}", fields = "{ 'book.title': 1, 'emprunteur.username': 1, 'reservationDate': 1 }")
    List<Reservation> findAllWithDetails();

    @Query("{'_id': ?0}")
    Reservation findByIdWithDetails(String id);
}
