package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.*;
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
        List<OrderItemResponse> items = new ArrayList<>();
        int totalBill=0;

        return null;
    }
}
