package com.example.mockTest.services;

import com.example.mockTest.entities.Car;
import com.example.mockTest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getList() {
        List<Car> cars = carRepository.findAll();
        return  cars;
    }

    @Override
    public List<Car> getListByLicense(String license) {
        List<Car> cars = new ArrayList<>();
        carRepository.findByLicensePlateContaining(license);
        return cars;
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public void update(String license, Car car) {
        Car car1 = carRepository.findByLicensePlate(license);
        car1.setCarColor(car.getCarColor());
        car1.setCarType(car.getCarType());
        car1.setCompany(car.getCompany());
        car1.setLicensePlate(car.getLicensePlate());
        car1.setParkinglot(car.getParkinglot());
        carRepository.save(car1);
    }
}
