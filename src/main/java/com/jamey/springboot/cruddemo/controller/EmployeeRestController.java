package com.jamey.springboot.cruddemo.controller;


import com.jamey.springboot.cruddemo.dao.EmployeeDAO;
import com.jamey.springboot.cruddemo.entity.Employee;
import com.jamey.springboot.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;



    @Autowired
    public void EmployeeRestController(EmployeeService theService){
        this.employeeService = theService;
    }



    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("Don't find EmployeeId - " + employeeId);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.update(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.update(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
            throw new RuntimeException("Don't find EmployeeId - " + employeeId);

        employeeService.deleteById(employeeId);

        return "Delete employee Id - " + employeeId;
    }

}
