package com.example.mockTest.services;

import com.example.mockTest.entities.Parkinglot;
import com.example.mockTest.repository.ParkinglotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class ParkinglotServiceImpl implements ParkinglotService{
    @Autowired
    ParkinglotRepository parkinglotRepository;

    @Override
    public List<Parkinglot> getList(){
        List<Parkinglot> parkinglots = parkinglotRepository.findAll();
        return parkinglots;
    }

    @Override
    public List<Parkinglot> findByParkName(String name) {
        List<Parkinglot> parkinglots = parkinglotRepository.findByParkNameContaining(name);
        return parkinglots;
    }

    @Override
    public void addParkinglot(Parkinglot parkinglot) {
        Parkinglot parkinglot1 = new Parkinglot();
        parkinglot1.setParkArea(parkinglot.getParkArea());
        parkinglot1.setParkName(parkinglot.getParkName());
        parkinglot1.setParkPlace(parkinglot.getParkPlace());
        parkinglot1.setParkPrice(parkinglot.getParkPrice());
        parkinglot1.setParkStatus(parkinglot.getParkStatus());
        parkinglotRepository.save(parkinglot1);
    }

    @Override
    public void updateParkinglot(Long id, Parkinglot parkinglot) {
        Parkinglot parkinglot1 = parkinglotRepository.findByParkId(id);
        parkinglot1.setParkStatus(parkinglot.getParkStatus());
        parkinglot1.setParkPlace(parkinglot.getParkPlace());
        parkinglot1.setParkPrice(parkinglot.getParkPrice());
        parkinglot1.setParkName(parkinglot.getParkName());
        parkinglot1.setParkArea(parkinglot.getParkArea());
        parkinglotRepository.save(parkinglot1);
    }

    @Override
    public void deleteParkinglot(Long id) {
        parkinglotRepository.deleteById(id);
    }
}
