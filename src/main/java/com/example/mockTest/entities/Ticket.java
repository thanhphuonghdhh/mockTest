package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;

@Entity
@Table
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private Time bookingTime;
    @NotNull
    @Column(length = 11)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "licensePlate", nullable = false)
    @Length(max = 11)
    private Car car;


}
