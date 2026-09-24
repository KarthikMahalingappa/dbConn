package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.exception.InsufficientStockException;
import com.firstapp.dbconn.exception.ProductNotFoundException;
import com.firstapp.dbconn.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsRepo repo;

    public Products addProduct(Products products){
      return repo.save(products);
    }
    public OrderResponse processOrder(OrderRequest orderRequest){
        List<OrderItemResponse> itemsresponse = new ArrayList<>();
        int totalBill=0;
        for(OrderItemRequest item : orderRequest.getAllProducts()){
            Products product = repo.findById(item.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product " + item.getProductId()+" not found"));
            if (item.getQuantity() > product.getQuantity()) {
                throw new InsufficientStockException("Only " + product.getQuantity() + " units of " + product.getName() + " are available");
            }
            int totalPrice = product.getPrice() * item.getQuantity();

            OrderItemResponse response = new OrderItemResponse(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    item.getQuantity(),
                    product.getExpday(),
                    totalPrice
            );
            itemsresponse.add(response);
            totalBill+=totalPrice;
        }
           OrderResponse orderResponse = new OrderResponse(itemsresponse,totalBill);

        return orderResponse;
    }

    public Products updateProduct(int id, Products products){
        Products existingProduct = repo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product"+id+"not found"));
        existingProduct.setName(products.getName());
        existingProduct.setPrice(products.getPrice());
        existingProduct.setQuantity(products.getQuantity());
        existingProduct.setExpday(products.getExpday());
        return repo.save(existingProduct);
    }

    public Products deleteProduct(int id){
        Products product = repo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product"+id+"not found"));
        repo.delete(product);
        return product;
    }
}
