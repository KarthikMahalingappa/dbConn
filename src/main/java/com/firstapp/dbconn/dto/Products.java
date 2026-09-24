package com.firstapp.dbconn.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    int id;
    int price;
    String name;
    int expday;
    int quantity;
}
