package com.example.mockTest.repository;

import com.example.mockTest.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmployeeNameContaining(String name);
    Employee findByEmployeeId(Long id);
}
