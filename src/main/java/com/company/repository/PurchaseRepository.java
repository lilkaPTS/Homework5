package com.company.repository;

import com.company.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.reflect.Field;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "Select to_char(purchase_date, 'Mon') from purchases GROUP BY to_char(purchase_date, 'Mon');" , nativeQuery = true)
    public List<String> getMonth();
}
