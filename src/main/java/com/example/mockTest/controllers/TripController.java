package com.example.mockTest.controllers;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.entities.Trip;
import com.example.mockTest.services.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TripService tripService;
    @GetMapping("/search")
    public ResponseEntity<?> getList(@RequestParam(required = false) String destination) {
        List<Trip> trips = tripService.getList();
        if (destination != null) trips = tripService.searchTripByDestination(destination);
        return ResponseEntity.ok(trips);
    }

    @PostMapping("")
    public ResponseEntity<?> addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return ResponseEntity.ok(trip);
    }


}
