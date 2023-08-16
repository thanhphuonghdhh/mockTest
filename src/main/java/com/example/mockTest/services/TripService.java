package com.example.mockTest.services;

import com.example.mockTest.entities.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    List<Trip> getList();
    Trip searchTripByName(String name);
    List<Trip> searchTripByDestination(String destination);
    void addTrip(Trip trip);
}
