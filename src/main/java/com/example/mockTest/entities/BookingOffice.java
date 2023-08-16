package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    private Date endContractDeadline;
    @NotNull
    @Column(length = 50)
    private String officeName;
    @NotNull
    @Column(length = 11)
    private String officePhone;
    @Column(length = 50)
    private String officePlace;
    @NotNull
    private Long officePrice;
    private Date startContractDeadline;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;
}
