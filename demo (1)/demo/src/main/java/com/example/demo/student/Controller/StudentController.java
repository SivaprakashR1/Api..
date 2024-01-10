package com.example.demo.student.Controller;

import com.example.demo.student.Model.Student;
import com.example.demo.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired    // injuction
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student>getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id")long id){
         return studentService.getStudentById(id);
    }
    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable("name")String name){
        return studentService.getStudentByName(name);
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student){   // given input will map to the student with the help of @RequestBody
        studentService.addNewStudent(student);
        return "Student Added Successfully";
    }
    @DeleteMapping(path = "{id}")
    public String deleteByStudentId(@PathVariable("id")Long id){
        studentService.deleteByStudentId(id);
        return "Id "+id+" Deleted successfully";
    }
    @PutMapping(path = "{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String email){

        studentService.updateStudent(studentId, name, email);
        return "Student updated successfully";
    }
}