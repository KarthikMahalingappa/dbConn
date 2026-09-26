package com.firstapp.dbconn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemResponse {
    int id;
    String name;
    int price;
    int expday;
    int quantity;
    int total;
}
