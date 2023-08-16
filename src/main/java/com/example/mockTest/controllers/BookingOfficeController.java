package com.example.mockTest.controllers;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.model.dto.BookingOfficeDTO;
import com.example.mockTest.services.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-office")
public class BookingOfficeController {
    @Autowired
    BookingOfficeService bookingOfficeService;

    @GetMapping("")
    public ResponseEntity<?> getList() {
        List<BookingOfficeDTO> bookingOfficeDTOS = bookingOfficeService.getList();
        return ResponseEntity.ok(bookingOfficeDTOS);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam(required = false) String name) {
        List<BookingOfficeDTO> bookingOffices = bookingOfficeService.searchByName(name);
        return ResponseEntity.ok(bookingOffices);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody BookingOfficeDTO bookingOfficeDTO) {
        bookingOfficeService.add(bookingOfficeDTO);
        return ResponseEntity.ok(bookingOfficeDTO);
    }
}
