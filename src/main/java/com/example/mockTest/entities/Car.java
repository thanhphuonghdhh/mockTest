package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @Length(max = 50)
    private String licensePlate;

    @NotNull
    @Column(length = 11)
    private String carColor;
    @Column(length = 50)
    private String carType;
    @Column(length = 50)
    private String company;
    @ManyToOne
    @JoinColumn(name = "parkId")
    private Parkinglot parkinglot;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "car")
    private Set<Ticket> listTicket = new HashSet<>();
}
