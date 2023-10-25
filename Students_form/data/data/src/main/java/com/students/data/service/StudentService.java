package com.students.data.service;

import com.students.data.model.StudentData;
import com.students.data.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("http://localhost:4200/")
@Service

public class StudentService {
    StudentRepository studentRepository;  // class to object creation

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentData getStudent(int id){
        return studentRepository.findById(id).get();

    }

    public String createStudent(StudentData studentData){
        studentRepository.save(studentData);
        return "Successfully Inserted";
    }
    public String updateStudent(StudentData studentData){
        studentRepository.save(studentData);
        return "Successfully Updated";
    }

    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "Successfully Deleted";
    }

    public List <StudentData> getAllStudentData(){
        return studentRepository.findAll();
    }
}
