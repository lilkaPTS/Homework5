package com.company.controller;

import com.company.model.Book;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return service.getAll();
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "bookId") Integer bookId) {
        return service.getById(bookId);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return service.create(book);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable(value = "bookId") Integer bookId) {
        return service.delete(bookId);
    }

    @PatchMapping("/books")
    public String updateBook(@RequestParam Integer bookId, @RequestParam(required = false) Integer price, @RequestParam(required = false) Integer quantity) {
        return service.update(bookId, price, quantity);
    }

    @PutMapping("/books")
    public String overwriteBook(@RequestBody Book book) {
        return service.overwrite(book);
    }
}
