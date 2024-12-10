package com.project.database.repository;
import com.project.database.entity.Book;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Book findByTitle(String name);
    List<Book> findByTitleContainingOrAuthorContainingOrIsbnContainingOrGenreContaining(String title, String author, String isbn, String genre);

    @Query(value = "{ $group: { _id: null, count: { $sum: 1 } } }")
    List<Map<String, Object>> getCustomBookQueryResult();

}


