package com.example.demo.student.Repository;

import com.example.demo.student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

//    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    void deleteByStudentId(@Param("id") long id);

    @Query("SELECT s FROM Student s WHERE s.name = :name")
    Student findByStudentName(@Param("name") String name);

//    @Query("SELECT * FROM your_table_name WHERE id = ?")
//    List<Student> findAllByIds(@Param("id")long id);



//    why jpa  ??????
//    named qurey
//    types of api

}