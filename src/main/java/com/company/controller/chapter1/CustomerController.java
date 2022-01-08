package com.company.controller.chapter1;

import com.company.model.Customer;
import com.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return service.getAll();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable(value = "customerId") Integer customerId) {
        return service.getById(customerId);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable(value = "customerId") Integer customerId) {
        return service.delete(customerId);
    }

    @PatchMapping("/customers")
    public String updateCustomer(@RequestParam Integer customerId, @RequestParam Integer discount) {
        return service.update(customerId, discount);
    }

    @PutMapping("/customers")
    public String overwriteBook(@RequestBody Customer customer) {
        return service.overwrite(customer);
    }

}
