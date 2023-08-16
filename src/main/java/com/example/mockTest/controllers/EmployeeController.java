package com.example.mockTest.controllers;

import com.example.mockTest.entities.Employee;
import com.example.mockTest.model.dto.EmployeeDTO;
import com.example.mockTest.repository.EmployeeRepository;
import com.example.mockTest.services.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



//    @GetMapping("")
//    public ResponseEntity<?> getEmployeeList() {
//        List<EmployeeDTO> employeeDTOS = employeeService.getEmployeeList();
//        return ResponseEntity.ok(employeeDTOS);
//    }

    @PostMapping("")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAll") // /getAll?name=value&JOB=
    public ResponseEntity<?> seacrhEmployeeByName(@RequestParam(name = "name",required = false) String name) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        if (name == null) employeeDTOS = employeeService.getEmployeeList();
        employeeDTOS = employeeService.searchEmployeeByName(name);
        if (employeeDTOS.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(employeeDTOS);
    }

    @GetMapping("/getEmployeeByID")
    public ResponseEntity<?> seacrhEmployeeByID(@RequestParam(required = false) Long id) {
        EmployeeDTO employeeDTOS = new EmployeeDTO();
        employeeDTOS = employeeService.searchEmployeeById(id);
        return ResponseEntity.ok(employeeDTOS);
    }
}
