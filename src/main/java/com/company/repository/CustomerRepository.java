package com.company.repository;

import com.company.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "Select area_of_residence from customers GROUP BY area_of_residence" , nativeQuery = true)
    public List<String> getAreas();
    @Query(value = "SELECT last_name, discount FROM customers where area_of_residence = 'Nizhegorodskij'", nativeQuery = true)
    public List<String> getInfo();

}
