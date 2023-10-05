package com.employee.app.dao;

import com.employee.app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Method to get list of all employee
     List<Employee> findAllEmployeeDetails();

    //Method to get employee details by ID
     Employee findEmployeeById(Integer id);

     void addEmployeeDetails(Employee employee);

     void updateEmployeeById(Employee employee);

     void deleteEmployeeById(Integer id);



}
