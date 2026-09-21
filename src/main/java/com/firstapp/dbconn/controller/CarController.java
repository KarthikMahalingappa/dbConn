package com.firstapp.dbconn.controller;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.service.CarService;
import com.firstapp.dbconn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/fetch/{id}")
    Car getCar(@PathVariable int id) {
        return carService.getCar(id);
    }

    @PostMapping("/takeOrder")
    AllProductResponse processOrder(@RequestBody AllProductRequest allProductRequest) {
        return productService.processOrder(allProductRequest);
    }

    @PostMapping("/addProduct")
    Products addProduct(@RequestBody Products products) {
        return productService.addProduct(products);
    }

}
