package com.example.mockTest.services;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.entities.Employee;
import com.example.mockTest.entities.Trip;
import com.example.mockTest.model.dto.BookingOfficeDTO;
import com.example.mockTest.model.mapper.BookingOfficeMapper;
import com.example.mockTest.repository.BookingOfficeRepository;
import com.example.mockTest.repository.TripRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingOfficeServiceImpl implements BookingOfficeService{
    @Autowired
    BookingOfficeRepository bookingOfficeRepository;
    @Autowired
    TripRepository tripRepository;

//    @PostConstruct
//    public void initData() {
//        if (bookingOfficeRepository != null) bookingOfficeRepository.deleteAll();
//        for (int i = 0; i < 10; i++) {
//            BookingOffice bookingOffice = new BookingOffice();
//            bookingOffice.setOfficeId((long) i);
//            bookingOffice.setEndContractDeadline(Date.valueOf("2021-10-01"));
//            bookingOffice.setOfficeName("An Binh");
//            bookingOffice.setOfficePhone("01212121");
//            bookingOffice.setOfficePlace("Hanoi");
//            bookingOffice.setOfficePrice((long) 121212);
//            bookingOffice.setStartContractDeadline(Date.valueOf("2021-01-01"));
//            Trip trip = new Trip();
//            trip.setTripId((long) 1);
//            trip.setBookedTicketNumber(1);
//            trip.setCarType("BMW");
//            trip.setDepartureDate(Date.valueOf("2021-10-01"));
//            trip.setDepartureTime(Time.valueOf("18:00:00"));
//            trip.setDestination("Hoi An");
//            trip.setDriver("An");
//            trip.setMaximumOnlineTicketNumber(1);
//            //bookingOffice.setTrip(trip);
//            //bookingOfficeRepository.save(bookingOffice);
//        }
//    }

    @Override
    public List<BookingOfficeDTO> getList() {
        List<BookingOffice> bookingOffices = bookingOfficeRepository.findAll();
        List<BookingOfficeDTO> bookingOfficeDTOS = new ArrayList<>();
        for (BookingOffice bookingOffice:bookingOffices){
            bookingOfficeDTOS.add(BookingOfficeMapper.toDTO(bookingOffice));
        }
        return bookingOfficeDTOS;
    }

    @Override
    public List<BookingOfficeDTO> searchByName(String name) {
        List<BookingOffice> bookingOffices = bookingOfficeRepository.findByOfficeNameContaining(name);
        List<BookingOfficeDTO> bookingOfficeDTOS = new ArrayList<>();
        for (BookingOffice bookingOffice:bookingOffices){
            bookingOfficeDTOS.add(BookingOfficeMapper.toDTO(bookingOffice));
        }
        return bookingOfficeDTOS;
    }

    @Override
    public void add(BookingOfficeDTO bookingOfficeDTO) {
        BookingOffice bookingOffice = new BookingOffice();
        bookingOffice.setOfficeName(bookingOfficeDTO.getOfficeName());
        bookingOffice.setOfficePrice(bookingOfficeDTO.getOfficePrice());
        bookingOffice.setOfficePlace(bookingOfficeDTO.getOfficePlace());
        bookingOffice.setOfficePhone(bookingOfficeDTO.getOfficePhone());
        bookingOffice.setStartContractDeadline(bookingOfficeDTO.getStartContractDeadline());
        bookingOffice.setEndContractDeadline(bookingOfficeDTO.getEndContractDeadline());
        bookingOffice.setTrip(tripRepository.findByDestination(bookingOfficeDTO.getTrip()));
        if (bookingOffice.getTrip() == null) return;
        bookingOfficeRepository.save(bookingOffice);
    }


}
