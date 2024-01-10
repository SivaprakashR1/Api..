package com.TeamLead.Employees.Repository;

import com.TeamLead.Employees.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
