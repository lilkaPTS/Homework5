package com.company.controller;

import com.company.model.Book;
import com.company.model.Customer;
import com.company.model.Purchase;
import com.company.model.Shop;
import com.company.repository.PurchaseRepository;
import com.company.service.PurchaseCreateService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class PurchaseController {

    @Autowired
    private PurchaseRepository repository;
    @Autowired
    private PurchaseCreateService purchaseCreateService;

    @GetMapping("/purchases")
    public List<Purchase> getAllPurchase(){
        return repository.findAll();
    }

    @GetMapping("/purchases/{purchaseId}")
    public ResponseEntity<Optional<Purchase>> getCustomerById(@PathVariable(value = "purchaseId") Integer purchaseId) {
        return repository.findById(purchaseId).isPresent() ? ResponseEntity.ok(repository.findById(purchaseId)) : ResponseEntity.notFound().build();
    }

    @PostMapping("/purchases")
    public String createPurchase(@RequestParam Date purchaseDate, @RequestParam Integer shopId, @RequestParam Integer customerId, @RequestParam Integer bookId, @RequestParam Integer quantity) {
        return purchaseCreateService.execute(purchaseDate, shopId, customerId, bookId, quantity);
    }
}
