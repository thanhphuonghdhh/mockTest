package com.example.mockTest.controllers;

import com.example.mockTest.entities.Parkinglot;
import com.example.mockTest.services.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkinglotController {
    @Autowired
    ParkinglotService parkinglotService;

    @GetMapping("/search")
    public ResponseEntity<?> getList(@RequestParam(required = false) String name) {
        List<Parkinglot> parkinglots = new ArrayList<>();
        if (name == null) parkinglots = parkinglotService.getList();
        else parkinglots = parkinglotService.findByParkName(name);
        return ResponseEntity.ok(parkinglots);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Parkinglot parkinglot) {
        parkinglotService.addParkinglot(parkinglot);
        return ResponseEntity.ok(parkinglot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody Parkinglot parkinglot) {
        parkinglotService.updateParkinglot(id,parkinglot);
        return ResponseEntity.ok(parkinglot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        parkinglotService.deleteParkinglot(id);
        return ResponseEntity.ok(id);
    }
}
