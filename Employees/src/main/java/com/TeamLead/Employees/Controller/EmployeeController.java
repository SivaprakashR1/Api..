package com.TeamLead.Employees.Controller;


import com.TeamLead.Employees.Entity.Employee;
import com.TeamLead.Employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee-teamleads")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save-all-details")
    public void saveAllDetails(@RequestBody Employee employee){
        employeeService.postAllDetails(employee);
    }

}
