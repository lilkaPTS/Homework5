package com.company.controller;

import com.company.repository.BookRepository;
import com.company.repository.CustomerRepository;
import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/output")
public class OutputController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/books")
    public List<String> getBookAssortment(){
        return bookRepository.getAssortment();
    }

    @GetMapping("/customersAreas")
    public List<String> getCustomerAreas() {
        return customerRepository.getAreas();
    }

    @GetMapping("/purchaseMonths")
    public List<String> getPurchaseMonths() {
        return purchaseRepository.getMonth();
    }

}
