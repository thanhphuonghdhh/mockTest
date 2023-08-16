package com.example.mockTest.repository;

import com.example.mockTest.entities.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkinglotRepository extends JpaRepository<Parkinglot,Long> {
    List<Parkinglot> findByParkNameContaining(String name);
    Parkinglot findByParkId(Long id);
}
