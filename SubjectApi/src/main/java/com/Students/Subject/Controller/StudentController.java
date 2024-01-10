package com.Students.Subject.Controller;


import com.Students.Subject.DTO.StudentSubjectDTO;
import com.Students.Subject.Entity.Student;
import com.Students.Subject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class StudentController {
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentService studentService;

@GetMapping("/get-by-subject")
public ResponseEntity<List<StudentSubjectDTO>> searchBySubject(@RequestParam String subjectName){
    List<StudentSubjectDTO> students = studentService.searchBySubjectName(subjectName);
    return ResponseEntity.ok(students);
}

    @GetMapping("/get-all-student-details")
    public List<StudentSubjectDTO> getAllDetails(){
        return studentService.getAllDetails();
}

@GetMapping("/get-by-student")
public ResponseEntity<List<StudentSubjectDTO>> searchByStudent(@RequestParam String studentName){
    List<StudentSubjectDTO> students = studentService.searchByStudentName(studentName);
    return ResponseEntity.ok(students);
}

@PostMapping("/PostDetails")
    public String SaveDetails(@RequestBody Student student){
    studentService.saveStudentDetails(student);
    return "Posted";
}
    @RequestMapping(value = "pagingAndSortingStudents/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public ResponseEntity<Page<StudentSubjectDTO>> studentPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return ResponseEntity.ok(studentService.getStudentPagination(pageNumber,pageSize).getBody());
    }
}
