package com.jamey.springboot.cruddemo.service;

import com.jamey.springboot.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee update(Employee employee);

    void deleteById(int id);
}
