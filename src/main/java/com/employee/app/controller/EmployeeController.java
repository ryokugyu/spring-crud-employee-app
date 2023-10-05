package com.employee.app.controller;

import com.employee.app.dao.EmployeeDAOImpl;
import com.employee.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAOImpl empDAO;

    @GetMapping("/getEmployeeDetails")
    public List<Employee> getEmployeeDetails(){
        return empDAO.findAllEmployeeDetails();
    }

    @GetMapping("/getEmployeeDetailsById/{id}")
    public Employee getEmployeeDetailsById(@PathVariable Integer id){
        return empDAO.findEmployeeById(id);
    }


    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee){
        empDAO.addEmployeeDetails(employee);
    }

    @PostMapping("/updateEmployeeDetails")
    public void updateEmployeeDetails(@RequestBody  Employee employee){
        empDAO.updateEmployeeById(employee);
    }

    @GetMapping("/deleteEmployeeDetails/{id}")
    public void deleteEmployeeDetailsById(@PathVariable Integer id){
        empDAO.deleteEmployeeById(id);
    }
}
