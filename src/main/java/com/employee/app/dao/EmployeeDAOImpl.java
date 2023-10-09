package com.employee.app.dao;

import com.employee.app.entity.Employee;
import com.employee.app.exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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


        //create typed query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee where id=:theData", Employee.class);

        // set the parameters
        theQuery.setParameter("theData", id);

        int size = theQuery.getResultList().size();
        if(size == 0) {
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }else{
            return entityManager.find(Employee.class,id);
        }

    }

    @Override
    @Transactional
    public void addEmployeeDetails(Employee employee) {
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
