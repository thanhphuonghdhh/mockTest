package com.example.mockTest;

import com.example.mockTest.entities.Employee;
import com.example.mockTest.repository.BookingOfficeRepository;
import com.example.mockTest.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class MockTestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MockTestApplication.class, args);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);


	}

}
