package com.example.mockTest.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingOfficeDTO {
    private Long officeId;

    private String officeName;

    private String officePhone;

    private String officePlace;

    private Long officePrice;
    private Date startContractDeadline;
    private Date endContractDeadline;
    private String trip;
}
