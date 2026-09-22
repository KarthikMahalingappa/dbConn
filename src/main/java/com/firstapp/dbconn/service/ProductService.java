package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.Products;
import com.firstapp.dbconn.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
