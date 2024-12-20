package com.example.student.service;


import com.example.student.dto.StudentDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    public <StudentDto> StudentDto saveStudent(StudentDto studentDto);

    public <StudentDto> List<StudentDto> getStudentBydateNaissance(LocalDate dateNaissance);


}
