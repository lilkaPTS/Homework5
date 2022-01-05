package com.company.service;

import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Optional<Book>> getById(Integer bookId) {
        return repository.findById(bookId).isPresent() ? ResponseEntity.ok(repository.findById(bookId)) : ResponseEntity.notFound().build();
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public String delete(Integer bookId) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(bookId).isPresent()) {
            repository.deleteById(bookId);
            status.append("Removal was successful");
        } else {
            status.append("Book with index ").append(bookId).append(" not found");
        }
        return status.toString();
    }
}
