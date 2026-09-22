package com.firstapp.dbconn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {


//    public List<OrderItemRequest> getAllProducts() {
//        return allProducts;
//    }
//
//    public void setAllProducts(List<OrderItemRequest> allProducts) {
//        this.allProducts = allProducts;
//    }

    List<OrderItemRequest> allProducts;

}
