package com.company.controller;

import com.company.model.Customer;
import com.company.repository.CustomerRepository;
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
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable(value = "customerId") Integer customerId) {
        return repository.findById(customerId).isPresent() ? ResponseEntity.ok(repository.findById(customerId)) : ResponseEntity.notFound().build();
    }
}
