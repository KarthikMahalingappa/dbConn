package com.firstapp.dbconn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
    int id;
    String name;
    int price;
    int quantity;
    int expday;
    int totalprice;
}
