package com.company.controller;

import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseRepository repository;

    @GetMapping("/purchases")
    public String getAllPurchase(){
        return repository.findAll().toString();
    }
}
