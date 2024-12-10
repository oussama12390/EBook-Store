package com.project.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.database.repository.BookRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books/statistics")
public class BookStatisticsController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Map<String, Object>> getBookStatistics() {
        return bookRepository.getCustomBookQueryResult();
    }
}
