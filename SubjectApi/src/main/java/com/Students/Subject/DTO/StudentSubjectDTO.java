package com.Students.Subject.DTO;

import com.Students.Subject.Entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectDTO {
    private Long id;
    private String name;
    private List<Subject> subjects;
}
