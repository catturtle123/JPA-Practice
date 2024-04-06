package com.jamey.springboot.cruddemo.dao;

import com.jamey.springboot.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("From Employee",Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee update(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteById(int theId) {
       Employee employee = entityManager.find(Employee.class,theId);
       entityManager.remove(employee);
    }
}
