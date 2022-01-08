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

    @Query(value = "SELECT c.last_name, s.title FROM purchases p INNER JOIN customers c on c.customer_id = p.customer_id INNER JOIN shops s on s.shop_id = p.shop_id", nativeQuery = true)
    public List<String> getInfoA();
    @Query(value = "SELECT p.purchase_date, c.last_name, c.discount, b.title, p.quantity FROM purchases p INNER JOIN customers c on c.customer_id = p.customer_id INNER JOIN books b on b.book_id = p.book_id", nativeQuery = true)
    public List<String> getInfoB();
}
