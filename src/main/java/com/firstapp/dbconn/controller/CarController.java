package com.firstapp.dbconn.controller;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.service.CarService;
import com.firstapp.dbconn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarService carService;
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.addCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        Car car = carService.getCar(id);
        return ResponseEntity.ok(car);
    }

    @PostMapping("/takeOrder")
    public ResponseEntity<AllProductResponse> processOrder(@RequestBody AllProductRequest allProductRequest) {
        AllProductResponse response = productService.processOrder(allProductRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Products> addProduct(@RequestBody Products products) {
        Products savedProduct = productService.addProduct(products);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
