package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductsRepo repo;

    public Products addProduct(Products products) {
        return repo.save(products);
    }

    public AllProductResponse processOrder(AllProductRequest allProductRequest) {
        List<ProductRequest> list = allProductRequest.getAllProducts();

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty.");
        }

        AllProductResponse allProductResponse = new AllProductResponse();
        int totalBill = 0;

        for (ProductRequest productRequest : list) {
            int id = productRequest.getProductId();
            int quantity = productRequest.getQuantity();
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0." + id);
            }

            Optional<Products> products = repo.findById(id);
            if (products.isEmpty()) {
                throw new IllegalArgumentException("Product with ID: " + id + " not found.");
            }

            String name = products.get().getName();
            int price = products.get().getPrice();
            int bill = price * quantity;
            totalBill += bill;
            ProductResponse productResponse = new ProductResponse(id, name, price, quantity, bill);
            allProductResponse.getAllProducts().add(productResponse);
        }
        allProductResponse.setTotalBill(totalBill);

        return allProductResponse;
    }
}
