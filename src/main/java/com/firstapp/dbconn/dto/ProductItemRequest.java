package com.firstapp.dbconn.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemRequest {
    @Positive(message = "Product ID must be greater than zero")
    int productId;
    @Positive(message = "Quantity must be greater than zero")
    int quantity;
}
