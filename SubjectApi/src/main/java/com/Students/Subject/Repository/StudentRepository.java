package com.Students.Subject.Repository;

import com.Students.Subject.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
//    List<Student> findBySubjectsSubject(String subjectName);

    List<Student> findByNameContaining(String StudentName);
    List<Student> findBySubjectsSubjectContaining(String subjectName);

    List<Student> findAll(Sort var1);
    Page<Student> findAll(Pageable pageable);

}
