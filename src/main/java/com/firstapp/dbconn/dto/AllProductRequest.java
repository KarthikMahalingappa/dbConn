package com.firstapp.dbconn.dto;

import java.util.ArrayList;
import java.util.List;

public class AllProductRequest {


    public List<ProductRequest> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<ProductRequest> allProducts) {
        this.allProducts = allProducts;
    }

    List<ProductRequest> allProducts;

}
