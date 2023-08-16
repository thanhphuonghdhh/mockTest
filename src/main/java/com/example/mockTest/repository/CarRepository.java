package com.example.mockTest.repository;


import com.example.mockTest.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {
    List<Car> findByLicensePlateContaining(String license);
    Car findByLicensePlate(String name);

}
