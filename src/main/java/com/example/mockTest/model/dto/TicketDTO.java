package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;


@Data
public class TicketDTO {

    private Long ticketId;

    private Time bookingTime;

    private String customerName;

    private Long trip;

    private String licensePlate;


}
