package com.company.repository;

import com.company.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "SELECT title FROM shops where location_area = 'Sovetskij' OR shops.location_area = 'Sormovskij'", nativeQuery = true)
    public List<String> getInfo();
}
