package com.example.demo.student.Service;

import com.example.demo.student.Model.Student;
import com.example.demo.student.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Component   // it is a bean
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(long id){
        return studentRepository.findById(id).get();
    }
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail((student.getEmail()));

        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email Taken!!");
        }
        studentRepository.save(student);
        System.out.println(student);
    }
    @Transactional
    public void deleteByStudentId(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+studentId + " does not exist");
        }
        studentRepository.deleteByStudentId(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "student with id "+" does not exist"));
    if (name != null && name.length()> 0 && !Objects.equals(student.getName(),name))
        student.setName(name);
    if(email != null && email.length()> 0 && !Objects.equals(student.getEmail(),email)){
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(email);
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken!!");
        }
        student.setEmail(email);
        }
    }
public Student getStudentByName(String name){
        return studentRepository.findByStudentName(name);
    }
}


