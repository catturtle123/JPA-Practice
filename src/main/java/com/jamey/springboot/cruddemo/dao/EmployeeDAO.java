package com.jamey.springboot.cruddemo.dao;

import com.jamey.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee update(Employee employee);

    void deleteById(int id);
}
