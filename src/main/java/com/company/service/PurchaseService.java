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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShopRepository shopRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    public ResponseEntity<Optional<Purchase>> getById(Integer purchaseId) {
        return purchaseRepository.findById(purchaseId).isPresent() ? ResponseEntity.ok(purchaseRepository.findById(purchaseId)) : ResponseEntity.notFound().build();
    }

    public String create(Date purchaseDate, Integer shopId, Integer customerId, Integer bookId, Integer quantity) {
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

    public String delete(Integer purchaseId) {
        StringBuilder status = new StringBuilder();
        if(purchaseRepository.findById(purchaseId).isPresent()) {
            purchaseRepository.deleteById(purchaseId);
            status.append("Removal was successful");
        } else {
            status.append("Purchase with index ").append(purchaseId).append(" not found");
        }
        return status.toString();
    }

}
