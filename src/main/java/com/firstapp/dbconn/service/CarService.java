package com.firstapp.dbconn.service;

import com.firstapp.dbconn.dto.Car;
import com.firstapp.dbconn.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public Car addCar(Car car){
        return carRepo.save(car);
    }

    public Car getCar(int id) {
        carRepo.deleteById(id);

        return null;
    }
}
