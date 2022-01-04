package com.company.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseId;
    @Column(name = "purchase_date")
    private Date purchaseDate;


    /*@ManyToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(name = "shop_id")
    private Shop shop;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(name = "book_id")
    private Book book;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;
    @Column(name = "purchase_amount")
    private int purchaseAmount;


    public Purchase(){}

    public Purchase(int purchaseId, Date purchaseDate, Shop shop, Customer customer, Book book, int quantity, int purchaseAmount) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.shop = shop;
        this.customer = customer;
        this.book = book;
        this.quantity = quantity;
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shopId) {
        this.shop = shopId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId && quantity == purchase.quantity && purchaseAmount == purchase.purchaseAmount && purchaseDate.equals(purchase.purchaseDate) && shop.equals(purchase.shop) && customer.equals(purchase.customer) && book.equals(purchase.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, purchaseDate, shop, customer, book, quantity, purchaseAmount);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", purchaseDate=" + purchaseDate +
                ", shop=" + shop +
                ", customer=" + customer +
                ", book=" + book +
                ", quantity=" + quantity +
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }
}
