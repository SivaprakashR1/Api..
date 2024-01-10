package com.TeamLead.Employees.Service;


import com.TeamLead.Employees.DTO.EmployeeLeadDTO;
import com.TeamLead.Employees.Entity.Employee;
import com.TeamLead.Employees.Repository.EmployeeRepository;
import com.TeamLead.Employees.Repository.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;
    private LeaderRepository leaderRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, LeaderRepository leaderRepository) {
        this.employeeRepository = employeeRepository;
        this.leaderRepository = leaderRepository;
    }

    public void postAllDetails(Employee employee){
         employeeRepository.save(employee);
    }
}
