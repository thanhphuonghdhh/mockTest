package com.example.mockTest.services;

import com.example.mockTest.entities.Parkinglot;
import com.example.mockTest.entities.Ticket;
import com.example.mockTest.entities.TicketDTO;
import com.example.mockTest.entities.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    List<TicketDTO> getList();
    List<TicketDTO> findByCustomer(String name);
    void delete(Long id);
    void add(TicketDTO ticketDTO);

}
