package com.company.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    private String title;
    private int price;
    private String stock;
    private int quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Collection<Purchase> purchases;

    public Book() {}

    public Book(String title, int price, String stock, int quantity) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && price == book.price && quantity == book.quantity && title.equals(book.title) && stock.equals(book.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, price, stock, quantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock='" + stock + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
