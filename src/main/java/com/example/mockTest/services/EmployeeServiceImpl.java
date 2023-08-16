package com.example.mockTest.services;

import com.example.mockTest.entities.Employee;
import com.example.mockTest.model.dto.EmployeeDTO;
import com.example.mockTest.model.mapper.EmployeeMapper;
import com.example.mockTest.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initData() {
        if (employeeRepository != null)employeeRepository.deleteAll();
        for (int i = 0; i < 10; i++) {
            employeeRepository.save(new Employee(Long.valueOf(i),"abc","IT","HN", Date.valueOf("2020-01-01"),"@","An","01291291","Adas","M"));
        }
    }
    @Override
    public List<EmployeeDTO> getEmployeeList() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee: employees) {
            employeeDTOS.add(EmployeeMapper.toDTO(employee));
        }
        return employeeDTOS;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByName(String name) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findByEmployeeNameContaining(name);
        for (Employee employee: employees) {
            employeeDTOS.add(EmployeeMapper.toDTO(employee));
        }
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO searchEmployeeById(Long id) {
        Employee employees = employeeRepository.findByEmployeeId(id);
        return EmployeeMapper.toDTO(employees);
    }
}
