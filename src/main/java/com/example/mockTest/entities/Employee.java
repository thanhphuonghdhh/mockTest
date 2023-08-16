package com.example.mockTest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotNull
    @Column(length = 50)
    private String account;
    @NotNull
    @Column(length = 10)
    private String department;
    @Column(length = 50)
    private String employeeAddress;
    private Date employeeBirthdate;
    @Column(length = 50)
    private String employeeEmail;
    @NotNull
    @Column(length = 50)
    private String employeeName;
    @NotNull
    @Column(length = 10)
    private String employeePhone;
    @NotNull
    @Column(length = 20)
    private String password;
    @NotNull
    @Column(length = 1)
    private String sex;


}
