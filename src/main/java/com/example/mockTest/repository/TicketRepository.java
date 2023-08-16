package com.example.mockTest.repository;

import com.example.mockTest.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByTicketId(Long id);
    List<Ticket> findByCustomerName(String name);
}
