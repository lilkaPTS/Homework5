package com.company.service;

import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public String update(Integer bookId, Integer price, Integer quantity) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(bookId).isPresent()) {
            Book book = repository.findById(bookId).get();
            if(price != null) {
                book.setPrice(price);
            }
            if(quantity != null) {
                book.setQuantity(quantity);
            }
            repository.save(book);
            if(price == null && quantity == null){
                status.append("All fields remain unchanged");
            } else {
                status.append("Update was successful");
            }
        } else {
            status.append("Book with index ").append(bookId).append(" not found");
        }
        return status.toString();
    }

    public String overwrite(Book obj) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(obj.getBookId()).isPresent()) {
            repository.save(obj);
            status.append("Update was successful");
        } else {
            status.append("Book with index ").append(obj.getBookId()).append(" not found");
        }
        return status.toString();
    }

}
