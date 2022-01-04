package com.company.controller;

import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ShopController {
    @Autowired
    private ShopRepository repository;

    @GetMapping("/shops")
    public String getAllShop(){
        return repository.findById(1).toString();
    }
}
