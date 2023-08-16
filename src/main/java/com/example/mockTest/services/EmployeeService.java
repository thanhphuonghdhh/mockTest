package com.example.mockTest.services;

import com.example.mockTest.entities.Employee;
import com.example.mockTest.model.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeDTO> getEmployeeList();
    void addEmployee(Employee employee);
    List<EmployeeDTO> searchEmployeeByName(String name);
    EmployeeDTO searchEmployeeById(Long id);
}
