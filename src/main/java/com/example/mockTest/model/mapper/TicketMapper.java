package com.example.mockTest.model.mapper;

import com.example.mockTest.entities.Ticket;
import com.example.mockTest.entities.TicketDTO;

public class TicketMapper {
    public static TicketDTO toDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketId(ticket.getTicketId());
        ticketDTO.setBookingTime(ticket.getBookingTime());
        ticketDTO.setCustomerName(ticket.getCustomerName());
        ticketDTO.setLicensePlate(ticket.getCar().getLicensePlate());
        ticketDTO.setTrip(ticket.getTrip().getTripId());
        return ticketDTO;
    }
}
