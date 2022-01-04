package com.company.controller;

import com.company.model.Shop;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ShopController {
    @Autowired
    private ShopRepository repository;

    @GetMapping("/shops")
    public List<Shop> getAllShop(){
        return repository.findAll();
    }
}
