package com.firstapp.dbconn.dto;

import java.util.ArrayList;
import java.util.List;

public class AllProductResponse {
    List<ProductResponse> allProducts = new ArrayList<>();
    ;
    int totalBill;

    public List<ProductResponse> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<ProductResponse> allProducts) {
        this.allProducts = allProducts;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }
}
