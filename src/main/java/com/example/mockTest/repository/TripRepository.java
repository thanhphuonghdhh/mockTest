package com.example.mockTest.repository;

import com.example.mockTest.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findByTripId(Long id);
    Trip findByDestination(String name);
    List<Trip> findByDestinationContaining(String destination);
}
