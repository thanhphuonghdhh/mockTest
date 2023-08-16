package com.example.mockTest.controllers;

import com.example.mockTest.entities.Car;
import com.example.mockTest.services.CarService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/search")
    public ResponseEntity<?> getList(@RequestParam(required = false) String license) {
        List<Car> cars = new ArrayList<>();
        if (license == null) cars = carService.getList();
        else cars = carService.getListByLicense(license);
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Car car) {
        carService.add(car);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{license}")
    public ResponseEntity<?> update(@PathVariable String license, @RequestBody Car car) {
        carService.update(license, car);
        return ResponseEntity.ok(car);
    }
}
