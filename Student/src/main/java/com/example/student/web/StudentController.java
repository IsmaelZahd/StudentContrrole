package com.example.student.web;


import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService ;

    @MutationMapping
    public StudentDto saveStudent(@Argument StudentDto student){
        return studentService.saveStudent(student);
    }

    @QueryMapping
    public List<StudentDto> getStudentBydateNaissance(@Argument LocalDate dateNaissance){
        return studentService.getStudentBydateNaissance(dateNaissance);
    }


}