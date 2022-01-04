package com.company.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int shopId;
    private String title;
    @Column(name = "location_area")
    private String locationArea;
    private int commission;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    private Collection<Purchase> purchases;

    public Shop() {}

    public Shop(int shopId, String title, String locationArea, int commission) {
        this.shopId = shopId;
        this.title = title;
        this.locationArea = locationArea;
        this.commission = commission;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return shopId == shop.shopId && commission == shop.commission && title.equals(shop.title) && locationArea.equals(shop.locationArea) && purchases.equals(shop.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, title, locationArea, commission, purchases);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", title='" + title + '\'' +
                ", locationArea='" + locationArea + '\'' +
                ", commission=" + commission +
                '}';
    }
}
