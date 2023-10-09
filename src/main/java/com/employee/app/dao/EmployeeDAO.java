package com.employee.app.dao;

import com.employee.app.entity.Employee;
import com.employee.app.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDAO {

    // Method to get list of all employee
     List<Employee> findAllEmployeeDetails();

    //Method to get employee details by ID
     Employee findEmployeeById(Integer id) throws EmployeeNotFoundException;

     void addEmployeeDetails(Employee employee);

     void updateEmployeeById(Employee employee);

     void deleteEmployeeById(Integer id);



}
