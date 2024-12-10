package com.project.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.database.entity.Book;
import com.project.database.repository.BookRepository;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book getBookByName(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book updateBook(String id, Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String searchTerm) {
        // Implementation to search for books based on the searchTerm
        // You might use repository methods like findByTitleContaining, findByAuthorContaining, etc.
        return bookRepository.findByTitleContainingOrAuthorContainingOrIsbnContainingOrGenreContaining(searchTerm, searchTerm, searchTerm, searchTerm);
    }

    public List<Map<String, Object>> getCustomBookQueryResult() {
        return bookRepository.getCustomBookQueryResult();
    }
    
}

