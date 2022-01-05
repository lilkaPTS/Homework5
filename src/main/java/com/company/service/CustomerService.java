package com.company.service;

import com.company.model.Book;
import com.company.model.Customer;
import com.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<Optional<Customer>> getById(Integer customerId) {
        return repository.findById(customerId).isPresent() ? ResponseEntity.ok(repository.findById(customerId)) : ResponseEntity.notFound().build();
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public String delete(Integer customerId) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(customerId).isPresent()) {
            repository.deleteById(customerId);
            status.append("Removal was successful");
        } else {
            status.append("Customer with index ").append(customerId).append(" not found");
        }
        return status.toString();
    }

    public String update(Integer customerId, Integer discount) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(customerId).isPresent()) {
            Customer customer = repository.findById(customerId).get();
            customer.setDiscount(discount);
            repository.save(customer);
            status.append("Update was successful");
        } else {
            status.append("Customer with index ").append(customerId).append(" not found");
        }
        return status.toString();
    }

    public String overwrite(Customer obj) {
        StringBuilder status = new StringBuilder();
        if(repository.findById(obj.getCustomerId()).isPresent()) {
            repository.save(obj);
            status.append("Update was successful");
        } else {
            status.append("Customer with index ").append(obj.getCustomerId()).append(" not found");
        }
        return status.toString();
    }
}
