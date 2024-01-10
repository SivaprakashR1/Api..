package com.students.data.service;

import com.students.data.model.StudentData;

import java.util.List;

public interface StudentServe {
    public String createStudent(StudentData studentData);
    public String updateStudent(StudentData studentData);
    public String deleteStudent(Integer id);
    public StudentData getStudent(Integer id);
    public List<StudentData> getAllStudent();
}
