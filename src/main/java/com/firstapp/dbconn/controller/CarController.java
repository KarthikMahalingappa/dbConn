package com.firstapp.dbconn.controller;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.service.CarService;
import com.firstapp.dbconn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/fetch/{id}")
    Car getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/takeOrder")
    ProductsBillResponse processOrder(@RequestBody ProductsBillRequest productsBillRequest){
        return productService.takeOrder(productsBillRequest);
    }


    @GetMapping("/product/{id}")
    Products getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping("/addProduct")
    Products addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @PutMapping("/updateProduct/{id}")
    Products updProduct(@PathVariable int id, @RequestBody Products prod){
        return productService.updProduct(id, prod);
    }

    @DeleteMapping("/deleteProduct/{id}")
    String dltProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
