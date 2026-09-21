package com.firstapp.dbconn.dto;

import java.util.List;

public class AllProductRequest {
    List<ProductRequest> allProducts;

    public List<ProductRequest> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<ProductRequest> allProducts) {
        this.allProducts = allProducts;
    }
}
