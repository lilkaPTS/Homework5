package com.company.service;

import com.company.model.Book;
import com.company.model.Customer;
import com.company.model.Purchase;
import com.company.model.Shop;
import com.company.repository.BookRepository;
import com.company.repository.CustomerRepository;
import com.company.repository.PurchaseRepository;
import com.company.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Optional;

@Service
public class PurchaseCreateService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ShopRepository shopRepository;

    public String execute(Date purchaseDate, Integer shopId, Integer customerId, Integer bookId, Integer quantity) {
        StringBuilder status = new StringBuilder();
        Optional<Shop> shop = shopRepository.findById(shopId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Book> book = bookRepository.findById(bookId);
        if(!shop.isPresent()) {
            status.append("There is no store with id = ").append(shopId).append("\t");
        }
        if(!customer.isPresent()) {
            status.append("There is no customer with id = ").append(customerId).append("\t");
        }
        if(!book.isPresent()) {
            status.append("There is no book with id = ").append(bookId).append("\t");
        }
        if(shop.isPresent() && customer.isPresent() && book.isPresent()) {
            Purchase purchase = new Purchase(purchaseDate, shop.get(), customer.get(), book.get(), quantity, book.get().getPrice()*quantity);
            purchaseRepository.save(purchase);
            status.append("Purchase made!");
        }
        return status.toString();
    }
}
