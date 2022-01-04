package com.company.controller;

import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public String getAllBook(){
        return repository.findAll().toString();
    }
}
