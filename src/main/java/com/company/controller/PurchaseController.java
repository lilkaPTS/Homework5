package com.company.controller;

import com.company.model.Purchase;
import com.company.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchase(){
        return service.getAll();
    }

    @GetMapping("/purchases/{purchaseId}")
    public ResponseEntity<Optional<Purchase>> getCustomerById(@PathVariable(value = "purchaseId") Integer purchaseId) {
        return service.getById(purchaseId);
    }

    @PostMapping("/purchases")
    public String createPurchase(@RequestParam Date purchaseDate, @RequestParam Integer shopId, @RequestParam Integer customerId, @RequestParam Integer bookId, @RequestParam Integer quantity) {
        return service.create(purchaseDate, shopId, customerId, bookId, quantity);
    }

    @DeleteMapping("/purchases/{purchaseId}")
    public String deletePurchase(@PathVariable(value = "purchaseId") Integer purchaseId) {
        return service.delete(purchaseId);
    }
}
