package com.Students.Subject.Service;

import com.Students.Subject.DTO.StudentSubjectDTO;
import com.Students.Subject.Entity.Student;
import com.Students.Subject.Repository.StudentRepository;
import com.Students.Subject.Repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    private StudentSubjectDTO convertEntityToDto(Student student){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        StudentSubjectDTO studentSubjectDTO = new StudentSubjectDTO();
        studentSubjectDTO = modelMapper.map(student, StudentSubjectDTO.class);
        return studentSubjectDTO;
    }

    private Student convertCtoToEntity(StudentSubjectDTO studentSubjectDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Student student = new Student();
        student = modelMapper.map(studentSubjectDTO,Student.class);
        return student;
    }

    public List<StudentSubjectDTO> getAllDetails() {
        logger.info("Getting all student Information");
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void saveStudentDetails(Student student){
        studentRepository.save(student);
    }

    public List<Student> getDetails(){
        logger.info("Getting all student Information");
    return studentRepository.findAll();
    }

    public List<StudentSubjectDTO> searchBySubjectName(String subjectName) {
        logger.info("Getting information for " + subjectName);
        List<Student> students = studentRepository.findBySubjectsSubjectContaining(subjectName);
        return students.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

//    public List<Student> searchBySubjectName(String subjectName){
//        logger.info("Getting information for "+subjectName);
//        return studentRepository.findBySubjectsSubjectContaining(subjectName);
//    }

    public List<StudentSubjectDTO> searchByStudentName(String studentName) {
        logger.info("Getting information for Student Name " + studentName);
        List<Student> students = studentRepository.findByNameContaining(studentName);
        return students.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

//    public List<Student> searchByStudentName(String studentName){
//        logger.info("Getting information for Student Name "+studentName);
//        List<Student> dataBaseName = studentRepository.findByNameContaining(studentName);
//        return dataBaseName;
//    }

    public ResponseEntity<Page<StudentSubjectDTO>> getStudentPagination(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        Page<Student> students = studentRepository.findAll(pageRequest);
        return ResponseEntity.ok(students.map(this::convertEntityToDto));
    }


//    public ResponseEntity<Page<Student>> getStudentPagination(Integer pageNumber, Integer pageSize) {
//        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,Sort.Direction.ASC,"name");
//        return ResponseEntity.ok(studentRepository.findAll(pageRequest));
//    }

}
