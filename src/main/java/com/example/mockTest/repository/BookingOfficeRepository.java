package com.example.mockTest.repository;

import com.example.mockTest.entities.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long> {
    List<BookingOffice> findByOfficeNameContaining(String name);
}
