package com.example.mockTest.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long employeeId;

    private String department;

    private String employeeAddress;
    private Date employeeBirthdate;

    private String employeeName;

    private String employeePhone;

}
