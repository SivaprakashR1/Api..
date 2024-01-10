package com.TeamLead.Employees.Repository;

import com.TeamLead.Employees.Entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderRepository extends JpaRepository<Leader,Long> {
}
