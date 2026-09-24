package com.firstapp.dbconn.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
    @Id
    int id;
    int price;
    String name;
    int expday;

    Products() {

    }

    public Products(int id, int price, String name, int expday) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.expday = expday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpday() {
        return expday;
    }

    public void setExpday(int expday) {
        this.expday = expday;
    }
}
