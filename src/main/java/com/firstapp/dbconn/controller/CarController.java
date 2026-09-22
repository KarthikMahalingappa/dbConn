package com.firstapp.dbconn.controller;

import com.firstapp.dbconn.dto.*;
import com.firstapp.dbconn.service.CarService;
import com.firstapp.dbconn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    ResponseBill processOrder(@RequestBody AllProductRequest allProductRequest){
        List<Response> r = new ArrayList<>();
        int bill = 0;
        for(ProductRequest pr:allProductRequest.getAllProducts()) {
            Products prod = productService.getProduct(pr.getProductId());
            r.add(new Response(prod.getPrice() * pr.getQuantity(),prod.getName(), prod.getPrice(),pr.getQuantity()));
            bill += prod.getPrice() * pr.getQuantity();
            System.out.println("productid:"+pr.getProductId());
            System.out.println("Quantity:"+pr.getQuantity());
        }
        ResponseBill rb = new ResponseBill(r, bill);
        return rb;
    }


    @PostMapping("/addProduct")
    Products addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

}
