package com.example.mockTest.services;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.entities.Trip;
import com.example.mockTest.repository.TripRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TripServiceImpl implements TripService{
    @Autowired
    TripRepository tripRepository;

//    @PostConstruct
//    public void initData() {
//        Trip trip = new Trip();
//        trip.setBookedTicketNumber(1);
//        trip.setCarType("Honda");
//        trip.setDepartureDate(Date.valueOf("2022-10-01"));
//        trip.setDepartureTime(Time.valueOf("19:00:00"));
//        trip.setDestination("Nha Trang");
//        trip.setDriver("Binh");
//        trip.setMaximumOnlineTicketNumber(1);
//        tripRepository.save(trip);
//        System.out.println(trip);
//    }

    @Override
    public List<Trip> getList() {
        List<Trip> list = tripRepository.findAll();
        return list;
    }

    @Override
    public Trip searchTripByName(String name) {
        List<Trip> tripList = tripRepository.findAll();
        for (Trip trip:tripList) {
            if (trip.getDestination().equals(name))
                return trip;
        }
        return null;
    }

    @Override
    public List<Trip> searchTripByDestination(String destination) {
        List<Trip> trips = tripRepository.findByDestinationContaining(destination);
        return trips;
    }

    @Override
    public void addTrip(Trip trip) {
        Trip trip1 = new Trip();
        trip1.setBookedTicketNumber(0);
        trip1.setCarType(trip.getCarType());
        trip1.setDepartureDate(trip.getDepartureDate());
        trip1.setDepartureTime(trip.getDepartureTime());
        trip1.setDriver(trip.getDriver());
        trip1.setMaximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber());
        trip1.setDestination(trip.getDestination());
        tripRepository.save(trip1);
    }
}
