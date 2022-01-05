package com.company.controller;

import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return repository.findAll();
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "bookId") Integer bookId) {
        return repository.findById(bookId).isPresent() ? ResponseEntity.ok(repository.findById(bookId)) : ResponseEntity.notFound().build();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return repository.save(book);
    }


}
