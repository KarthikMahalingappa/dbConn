package com.firstapp.dbconn.repository;

import com.firstapp.dbconn.dto.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {
}
