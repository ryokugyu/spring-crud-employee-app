package com.employee.app.controller;

import com.employee.app.dao.EmployeeDAOImpl;
import com.employee.app.entity.Employee;
import com.employee.app.errorResponse.EmployeeErrorResponse;
import com.employee.app.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeDAOImpl empDAO;

    public EmployeeController(EmployeeDAOImpl empDAO) {
        this.empDAO = empDAO;
    }

    @GetMapping("/getEmployeeDetails")
    public List<Employee> getEmployeeDetails() {
        return empDAO.findAllEmployeeDetails();
    }

    @GetMapping("/getEmployeeDetailsById/{id}")
    public Employee getEmployeeDetailsById(@PathVariable Integer id) {

        if (true) {
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }
        return empDAO.findEmployeeById(id);
    }


    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        empDAO.addEmployeeDetails(employee);
    }

    @PostMapping("/updateEmployeeDetails")
    public void updateEmployeeDetails(@RequestBody Employee employee) {
        empDAO.updateEmployeeById(employee);
    }

    @GetMapping("/deleteEmployeeDetails/{id}")
    public void deleteEmployeeDetailsById(@PathVariable Integer id) {
        empDAO.deleteEmployeeById(id);
    }
}


