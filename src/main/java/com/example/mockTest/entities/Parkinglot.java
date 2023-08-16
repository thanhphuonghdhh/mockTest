package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;
    private Long parkArea;
    @NotNull
    @Column(length = 50)
    private String parkName;
    @NotNull
    @Column(length = 11)
    private String parkPlace;
    private Long parkPrice;
    @Column(length = 50)
    private String parkStatus;

}
