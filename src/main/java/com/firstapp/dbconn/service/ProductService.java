package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.exception.InSufficientQuantityException;
import com.firstapp.dbconn.exception.ProductNotFoundException;
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
        if(p.isEmpty()){
            throw new ProductNotFoundException("Product id:" + id + " is not Available");
        }
        return p.get();
    }

    public Products updProduct(int id, Products prod){
        Products existing = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product id:" + id + " is not Available"));
        existing.setName(prod.getName());
        existing.setPrice(prod.getPrice());
        existing.setQuantity(prod.getQuantity());
        existing.setExpday(prod.getExpday());

        return repo.save(existing);
    }

    public String deleteProduct(int id) {
        Products product = repo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product id:"+id+" is not found"));
        repo.deleteById(id);
        return "Product id:" + id + " is deleted Successsfully";
    }

    public ProductsBillResponse takeOrder(ProductsBillRequest productRequest){
        List<ProductItemResponse> list = new ArrayList<>();
        int billAmount = 0;
        for(ProductItemRequest prod: productRequest.getAllProducts()){
            Products product = repo.findById(prod.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product id:" + prod.getProductId() + " is not Available"));
            if(prod.getQuantity() > product.getQuantity()){
                throw new InSufficientQuantityException("There is no such Quantity exist, Available stock:" + product.getQuantity());
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
