package com.example.mockTest.services;

import com.example.mockTest.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getList();
    List<Car> getListByLicense(String license);
    void add(Car car);
    void update(String license, Car car);
}
