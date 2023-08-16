package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    private int bookedTicketNumber;
    @NotNull
    @Column(length = 11)
    private String carType;
    @NotNull
    private Date departureDate;
    @NotNull
    private Time departureTime;
    @NotNull
    @Column(length = 50)
    private String destination;
    @NotNull
    @Column(length = 11)
    private String driver;
    @NotNull
    private int maximumOnlineTicketNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private Set<Ticket> tickets = new HashSet<>();

}
