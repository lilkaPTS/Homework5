package com.company.controller;

import com.company.model.Shop;
import com.company.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class ShopController {
    @Autowired
    private ShopService service;

    @GetMapping("/shops")
    public List<Shop> getAllShop(){
        return service.getAll();
    }

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Optional<Shop>> getShopById(@PathVariable(value = "shopId") Integer shopId) {
        return service.getById(shopId);
    }

    @PostMapping("/shops")
    public Shop createShop(@RequestBody Shop shop) {
        return service.create(shop);
    }

    @DeleteMapping("/shops/{shopId}")
    public String deleteShop(@PathVariable(value = "shopId") Integer shopId) {
        return service.delete(shopId);
    }

    @PatchMapping("/shops")
    public String updateCustomer(@RequestParam Integer shopId, @RequestParam String locationArea) {
        return service.update(shopId, locationArea);
    }

    @PutMapping("/shops")
    public String overwriteBook(@RequestBody Shop shop) {
        return service.overwrite(shop);
    }
}
