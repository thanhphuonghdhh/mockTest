package com.example.mockTest.services;

import com.example.mockTest.entities.Ticket;
import com.example.mockTest.entities.TicketDTO;
import com.example.mockTest.entities.Trip;
import com.example.mockTest.model.mapper.TicketMapper;
import com.example.mockTest.repository.CarRepository;
import com.example.mockTest.repository.TicketRepository;
import com.example.mockTest.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<TicketDTO> getList() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for (Ticket ticket:tickets) {
            ticketDTOS.add(TicketMapper.toDTO(ticket));
        }
        return ticketDTOS;
    }

    @Override
    public List<TicketDTO> findByCustomer(String name) {
        List<Ticket> tickets = ticketRepository.findByCustomerName(name);
        List<TicketDTO> ticketDTOS = new ArrayList<>();
        for (Ticket ticket:tickets) {
            ticketDTOS.add(TicketMapper.toDTO(ticket));
        }
        return ticketDTOS;
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void add(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setBookingTime(ticketDTO.getBookingTime());
        ticket.setCustomerName(ticketDTO.getCustomerName());
        ticket.setTrip(tripRepository.findByTripId(ticketDTO.getTicketId()));
        ticket.setCar(carRepository.findByLicensePlate(ticketDTO.getLicensePlate()));
        ticketRepository.save(ticket);
    }


}
