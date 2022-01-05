package com.company.service;

import com.company.model.Shop;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopRepository repository;

    public List<Shop> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Optional<Shop>> getById(Integer shopId) {
        return repository.findById(shopId).isPresent() ? ResponseEntity.ok(repository.findById(shopId)) : ResponseEntity.notFound().build();
    }

    public Shop create(Shop shop) {
        return repository.save(shop);
    }

    public String delete(Integer shopId) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(shopId).isPresent()) {
            repository.deleteById(shopId);
            status.append("Removal was successful");
        } else {
            status.append("Shop with index ").append(shopId).append(" not found");
        }
        return status.toString();
    }

    public String update(Integer shopId, String locationArea) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(shopId).isPresent()) {
            Shop shop = repository.findById(shopId).get();
            shop.setLocationArea(locationArea);
            repository.save(shop);
            status.append("Update was successful");
        } else {
            status.append("Shop with index ").append(shopId).append(" not found");
        }
        return status.toString();
    }

    public String overwrite(Shop obj) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(obj.getShopId()).isPresent()) {
            repository.save(obj);
            status.append("Update was successful");
        } else {
            status.append("Shop with index ").append(obj.getShopId()).append(" not found");
        }
        return status.toString();
    }
}
