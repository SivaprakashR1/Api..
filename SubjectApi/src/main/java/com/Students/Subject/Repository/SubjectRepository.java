package com.Students.Subject.Repository;

import com.Students.Subject.Entity.Student;
import com.Students.Subject.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
