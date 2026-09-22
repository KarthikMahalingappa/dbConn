package com.firstapp.dbconn.dto;

public class Response {
    static int totalBill;
    String name;
    int quantity;

    public Response(int bill, String name, int price, int quantity) {
        this.bill = bill;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalBill = bill * quantity;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int price;
    int bill;
}
