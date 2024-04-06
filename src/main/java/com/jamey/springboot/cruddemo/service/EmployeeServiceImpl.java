package com.jamey.springboot.cruddemo.service;

import com.jamey.springboot.cruddemo.dao.EmployeeDAO;
import com.jamey.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public void EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
