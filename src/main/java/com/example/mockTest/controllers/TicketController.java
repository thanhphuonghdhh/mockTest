package com.example.mockTest.controllers;

import com.example.mockTest.entities.Parkinglot;
import com.example.mockTest.entities.Ticket;
import com.example.mockTest.entities.TicketDTO;
import com.example.mockTest.entities.Trip;
import com.example.mockTest.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/search")
    public ResponseEntity<?> getList(@RequestParam(required = false) String customer) {
        List<TicketDTO> ticketDTOS = ticketService.getList();
        if (customer != null) ticketDTOS = ticketService.findByCustomer(customer);
        return ResponseEntity.ok(ticketDTOS);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody TicketDTO ticketDTO) {
        ticketService.add(ticketDTO);
        return ResponseEntity.ok(ticketDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        ticketService.delete(id);
        return ResponseEntity.ok(id);
    }
}
