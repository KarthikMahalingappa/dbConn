package com.firstapp.dbconn.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsBillRequest {
    @Valid
    List<ProductItemRequest> allProducts;
}
