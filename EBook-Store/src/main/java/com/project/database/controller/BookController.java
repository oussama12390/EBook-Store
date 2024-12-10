package com.project.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.database.entity.Book;
import com.project.database.repository.BookRepository;
import com.project.database.service.ImageStorageService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/books")

public class BookController {

    @Autowired
    private BookRepository bookRepository;
    


    @Autowired
    private ImageStorageService imageStorageService;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
public Book addBook(@RequestParam("title") String title,
                    @RequestParam("author") String author,
                    @RequestParam("isbn") String isbn,
                    @RequestParam("description") String description,
                    @RequestParam("quantite") int quantite,
                    @RequestParam("genre") String genre,
                    @RequestParam("imageUrl") MultipartFile imageUrl) {

    try {
        // Create a new Book object
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setDescription(description);
        book.setQuantite(quantite);
        book.setGenre(genre);

        // Save the image and set the actual path in the book entity
        String imagePath = imageStorageService.saveImage(imageUrl);
        book.setImageUrl(imagePath);

        // Save the book to the database
        return bookRepository.save(book);
    } catch (Exception e) {
        // Log the exception
        e.printStackTrace();
        throw new RuntimeException("Error adding book", e);
    }
}

    
    // @PostMapping
    // public Book addBook(@RequestParam("title") String title,
    //                     @RequestParam("author") String author,
    //                     @RequestParam("isbn") String isbn,
    //                     @RequestParam("description") String description,
    //                     @RequestParam("quantite") int quantite,
    //                     @RequestParam("genre") String genre,
    //                     @RequestParam("imageUrl") String imageUrl) {

    //     Book book = new Book();
    //     book.setTitle(title);
    //     book.setAuthor(author);
    //     book.setIsbn(isbn);
    //     book.setDescription(description);
    //     book.setQuantite(quantite);
    //     book.setGenre(genre);

    //     try {
            
    //         book.setImageUrl(imageUrl); // Set the actual path after saving the file
    //         return bookRepository.save(book);
    //     } catch (Exception e) {
    //         throw new RuntimeException("Error adding book", e);
    //     }
    // }

    // @PutMapping("/{id}")
    // public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
    //     updatedBook.setId(id);
    //     return bookRepository.save(updatedBook);
    // }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestParam("title") String title,
    @RequestParam("author") String author, @RequestParam("isbn") String isbn,
    @RequestParam("description") String description, @RequestParam("quantite") int quantite,
    @RequestParam("genre") String genre, @RequestParam("imageUrl") String imageUrl) {

    Book updatedBook = new Book();
    updatedBook.setId(id);
    updatedBook.setTitle(title);
    updatedBook.setAuthor(author);
    updatedBook.setIsbn(isbn);
    updatedBook.setDescription(description);
    updatedBook.setQuantite(quantite);
    updatedBook.setGenre(genre);
    updatedBook.setImageUrl(imageUrl);

    return bookRepository.save(updatedBook);
}

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String searchTerm) {
        if (searchTerm != null && !searchTerm.isEmpty()) {
            // Perform search based on the 'searchTerm' parameter
            return bookRepository.findByTitleContainingOrAuthorContainingOrIsbnContainingOrGenreContaining(searchTerm, searchTerm, searchTerm, searchTerm);
        } else {
            // Return all books if no search parameter is provided
            return bookRepository.findAll();
        }
    }

    @PutMapping("/updateQuantity/{bookId}")
    public ResponseEntity<Book> updateBookQuantity(
            @PathVariable String bookId,
            @RequestBody UpdateQuantityRequest request
    ) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setQuantite(request.getNewQuantity());
            bookRepository.save(book);

            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

