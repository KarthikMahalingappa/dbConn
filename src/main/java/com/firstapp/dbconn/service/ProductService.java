package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductsRepo repo;

    public Products addProduct(Products products) {
        return repo.save(products);
    }

    public AllProductResponse processOrder(AllProductRequest allProductRequest) {
        List<ProductRequest> list = allProductRequest.getAllProducts();
        AllProductResponse allProductResponse = new AllProductResponse();
        int totalBill = 0;

        for (ProductRequest productRequest : list) {
            int id = productRequest.getProductId();
            int quantity = productRequest.getQuantity();

            Products products = repo.findById(id).orElse(null);
            if (products != null) {
                String name = products.getName();
                int price = products.getPrice();
                int bill = price * quantity;
                totalBill += bill;
                ProductResponse productResponse = new ProductResponse(id, name, price, quantity, bill);
                allProductResponse.getAllProducts().add(productResponse);
                allProductResponse.setTotalBill(totalBill);
            }
        }

        return allProductResponse;
    }
}
