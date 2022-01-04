package com.company.controller;

import com.company.model.Purchase;
import com.company.model.Shop;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class ShopController {
    @Autowired
    private ShopRepository repository;

    @GetMapping("/shops")
    public List<Shop> getAllShop(){
        return repository.findAll();
    }

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Optional<Shop>> getCustomerById(@PathVariable(value = "shopId") Integer shopId) {
        return repository.findById(shopId).isPresent() ? ResponseEntity.ok(repository.findById(shopId)) : ResponseEntity.notFound().build();
    }
}
