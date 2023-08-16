package com.example.mockTest.model.mapper;

import com.example.mockTest.entities.BookingOffice;
import com.example.mockTest.model.dto.BookingOfficeDTO;

public class BookingOfficeMapper {
    public static BookingOfficeDTO toDTO(BookingOffice bookingOffice) {
        BookingOfficeDTO bookingOfficeDTO = new BookingOfficeDTO();
        bookingOfficeDTO.setOfficeId(bookingOffice.getOfficeId());
        bookingOfficeDTO.setOfficeName(bookingOffice.getOfficeName());
        bookingOfficeDTO.setOfficePhone(bookingOffice.getOfficePhone());
        bookingOfficeDTO.setOfficePlace(bookingOffice.getOfficePlace());
        bookingOfficeDTO.setOfficePrice(bookingOffice.getOfficePrice());
        bookingOfficeDTO.setEndContractDeadline(bookingOffice.getEndContractDeadline());
        bookingOfficeDTO.setStartContractDeadline(bookingOffice.getStartContractDeadline());
        if (bookingOffice.getTrip() != null)
            bookingOfficeDTO.setTrip(bookingOffice.getTrip().getDestination());
        return bookingOfficeDTO;
    }
}
