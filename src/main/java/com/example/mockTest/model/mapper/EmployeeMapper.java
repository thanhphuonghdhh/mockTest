package com.example.mockTest.model.mapper;

import com.example.mockTest.entities.Employee;
import com.example.mockTest.model.dto.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setEmployeeAddress(employee.getEmployeeAddress());
        employeeDTO.setEmployeePhone(employee.getEmployeePhone());
        employeeDTO.setEmployeeBirthdate(employee.getEmployeeBirthdate());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }
}
