package com.employee.app.dao;

import com.employee.app.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployeeDetails() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);

    }

    @Override
    @Transactional
    public void updateEmployeeById(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(Integer id) {

        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);

    }
}
