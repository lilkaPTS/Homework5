package com.company.controller;

import com.company.model.Book;
import com.company.model.Customer;
import com.company.model.Purchase;
import com.company.model.Shop;
import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseRepository repository;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchase(){
        return repository.findAll();
    }
}
