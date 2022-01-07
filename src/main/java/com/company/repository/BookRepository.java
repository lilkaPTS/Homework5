package com.company.repository;

import com.company.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select title, price from books GROUP BY title, price", nativeQuery = true)
    public List<String> getAssortment();

    @Query(value = "SELECT title, price FROM books WHERE title LIKE '%Windows%' OR price > 20000", nativeQuery = true)
    public List<String> getInfo();

}
