package com.mycode.demo.services;

import com.mycode.demo.exceptions.UserNotFoundException;
import com.mycode.demo.models.Employee;
import com.mycode.demo.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee emp) {
        emp.setEmpCode(UUID.randomUUID().toString());
        return this.repo.save(emp);
    }

    public List<Employee> getAllEmployee() {
        return this.repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return this.repo.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.repo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        // Try to find the employee by the id, however, If you cannot find the employee throw the exception
        return this.repo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }
}
