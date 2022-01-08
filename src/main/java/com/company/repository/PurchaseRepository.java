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

    @Query(value = "    SELECT p.purchase_id, c.last_name, p.purchase_date FROM purchases p\n" +
            "    INNER JOIN customers c on c.customer_id = p.customer_id\n" +
            "    WHERE p.purchase_amount>60000", nativeQuery = true)
    public List<String> getDefineA();
    @Query(value = "SELECT c.last_name, s.location_area, p.purchase_date FROM purchases p\n" +
            "    INNER JOIN customers c on c.customer_id = p.customer_id\n" +
            "    INNER JOIN shops s on s.shop_id = p.shop_id\n" +
            "    WHERE s.location_area = c.area_of_residence\n" +
            "    AND EXTRACT(Month FROM purchase_date) >= 3\n" +
            "    AND EXTRACT(YEAR FROM purchase_date) = 2022\n" +
            "    ORDER BY p.purchase_date", nativeQuery = true)
    public List<String> getDefineB();
    @Query(value = "    SELECT s.title FROM purchases p\n" +
            "    INNER JOIN shops s on s.shop_id = p.shop_id\n" +
            "    INNER JOIN customers c on c.customer_id = p.customer_id\n" +
            "    WHERE s.location_area != 'Avtozavodskij'\n" +
            "    AND (c.discount >= 10 AND c.discount <= 15) GROUP BY title", nativeQuery = true)
    public List<String> getDefineC();
    @Query(value = "    SELECT b.title, b.stock, b.quantity, b.price FROM purchases p\n" +
            "    INNER JOIN books b on b.book_id = p.book_id\n" +
            "    INNER JOIN shops s on s.shop_id = p.shop_id\n" +
            "    WHERE b.stock = s.location_area AND b.quantity > 10 ORDER BY price", nativeQuery = true)
    public List<String> getDefineD();


}
