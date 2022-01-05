package com.company.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "area_of_residence")
    private String areaOfResidence;
    private int discount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Collection<Purchase> purchases;

    public Customer(){}

    public Customer(String lastName, String areaOfResidence, int discount) {
        this.lastName = lastName;
        this.areaOfResidence = areaOfResidence;
        this.discount = discount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAreaOfResidence() {
        return areaOfResidence;
    }

    public void setAreaOfResidence(String areaOfResidence) {
        this.areaOfResidence = areaOfResidence;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && discount == customer.discount && lastName.equals(customer.lastName) && areaOfResidence.equals(customer.areaOfResidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, lastName, areaOfResidence, discount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", lastName='" + lastName + '\'' +
                ", areaOfResidence='" + areaOfResidence + '\'' +
                ", discount=" + discount +
                '}';
    }
}
