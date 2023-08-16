package com.example.mockTest.services;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.model.dto.BookingOfficeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingOfficeService {
    List<BookingOfficeDTO> getList();
    List<BookingOfficeDTO> searchByName(String name);
    void add(BookingOfficeDTO bookingOfficeDTO);

}
