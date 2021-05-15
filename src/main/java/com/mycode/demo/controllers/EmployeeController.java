package com.mycode.demo.controllers;

import com.mycode.demo.models.Employee;
import com.mycode.demo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
// Add transactional to
@Transactional
// Any url access to this Employee Controller has to have the '/employee' at the first
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Get request
    @GetMapping("/all")
    // return the HTTP response, so I call the ResponseEntity(is Generic)
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        // The user will know the HTTp response is 200
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        // CREATED status means Create new Object
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    // Put ? because it does not return any thing
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        System.out.println(" Not working");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
