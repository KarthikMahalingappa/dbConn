package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductsRepo repo;

    public Products addProduct(Products products){
      return repo.save(products);
    }

    public Products getProduct(int id){

        Optional<Products> p = repo.findById(id);
        if(p.isPresent()){
            return p.get();
        }
        return null;
    }

    public Products updProduct(int id, Products prod){
        Products existing = repo.findById(id).orElseThrow(() -> new RuntimeException("error"));
        existing.setName(prod.getName());
        existing.setPrice(prod.getPrice());
        existing.setQuantity(prod.getQuantity());
        existing.setExpday(prod.getExpday());

        return repo.save(existing);
    }

    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Product id:" + id + " is deleted Successsfully";
    }

    public ProductsBillResponse takeOrder(ProductsBillRequest productRequest){
        List<ProductItemResponse> list = new ArrayList<>();
        int billAmount = 0;
        for(ProductItemRequest prod: productRequest.getAllProducts()){
            Products product = repo.findById(prod.getProductId()).orElseThrow(() -> new RuntimeException("error"));
            if(prod.getQuantity() > product.getQuantity()){
                throw new RuntimeException("Error low Quantity is Available");
            }
            int total = product.getPrice() * prod.getQuantity();
            ProductItemResponse pr = new ProductItemResponse(product.getId(),product.getName(), product.getPrice(), product.getExpday(), prod.getQuantity(), total);
            list.add(pr);
            billAmount += total;
        }
        ProductsBillResponse response = new ProductsBillResponse(list, billAmount);
        return response;
    }
}
