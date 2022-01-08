package com.company.controller.chapter3;

import com.company.repository.BookRepository;
import com.company.repository.CustomerRepository;
import com.company.repository.PurchaseRepository;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/info")
public class InfoController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/customers")
    public List<String> getCustomersNameAndDiscount(){
        return customerRepository.getInfo();
    }
    @GetMapping("/shops")
    public List<String> getShopsTitle(){
        return shopRepository.getInfo();
    }

    @GetMapping("/books")
    public List<String> getBooksTitleAndPrise(){
        return bookRepository.getInfo();
    }
}
