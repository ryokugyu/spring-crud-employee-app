package com.employee.app.dao;

import com.employee.app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Method to get list of all employee
    public List<Employee> findAllEmployeeDetails();

    //Method to get employee details by ID
    public Employee findEmployeeById();

    public void addEmployee(Employee employee);

    public void updateEmployeeById(Employee employee);

    public void deleteEmployeeById(Integer id);



}
