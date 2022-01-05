package com.company.controller;

import com.company.model.Book;
import com.company.model.Customer;
import com.company.model.Purchase;
import com.company.model.Shop;
import com.company.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseRepository repository;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchase(){
        return repository.findAll();
    }

    @GetMapping("/purchases/{purchaseId}")
    public ResponseEntity<Optional<Purchase>> getCustomerById(@PathVariable(value = "purchaseId") Integer purchaseId) {
        return repository.findById(purchaseId).isPresent() ? ResponseEntity.ok(repository.findById(purchaseId)) : ResponseEntity.notFound().build();
    }

    @PostMapping("/purchases")
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return repository.save(purchase);
    }
}
