package com.mycode.demo.repositories;

import com.mycode.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    // return Optional because the Employee may not exist
    Optional<Employee> findEmployeeById(Long id);
}
