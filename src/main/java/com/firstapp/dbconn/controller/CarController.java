package com.firstapp.dbconn.controller;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.service.CarService;
import com.firstapp.dbconn.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/add")
    Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/fetch/{id}")
    Car getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/takeOrder")
    OrderResponse processOrder(@Valid @RequestBody OrderRequest orderRequest){
        return productService.processOrder(orderRequest);

//                for(OrderItemRequest pr: orderRequest.getAllProducts()) {
//                    System.out.println("productid:"+pr.getProductId());
//                    System.out.println("Quantity:"+pr.getQuantity());
//                }
//
//        return null;
    }

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    Products addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }
    @PutMapping("/updateproducts/{id}")
    Products updateProduct(@PathVariable int id, @RequestBody Products products){
        return productService.updateProduct(id,products);
    }
    @DeleteMapping("/deleteproducts/{id}")
    Products updateProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
