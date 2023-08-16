package com.example.mockTest.services;

import com.example.mockTest.entities.Parkinglot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkinglotService {
    List<Parkinglot> getList();
    List<Parkinglot> findByParkName(String name);
    void addParkinglot(Parkinglot parkinglot);
    void updateParkinglot(Long id,Parkinglot parkinglot);
    void deleteParkinglot(Long id);
}
