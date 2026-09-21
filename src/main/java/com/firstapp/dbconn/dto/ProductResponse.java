package com.firstapp.dbconn.dto;

public class ProductResponse {
    int id;
    String name;
    int price;
    int quantity;
    int bill;

    ProductResponse() {

    }

    public ProductResponse(int id, String name, int price, int quantity, int bill) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
}
