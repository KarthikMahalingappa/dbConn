package com.firstapp.dbconn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    List<OrderItemResponse> itemsresponse;
    int totalBill;
}
