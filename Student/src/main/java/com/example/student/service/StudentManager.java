package com.example.student.service;


import com.example.student.dao.entities.Student;
import com.example.student.dao.repositories.StudentRepository;
import com.example.student.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.student.dto.StudentDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService{

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;


    @Override
    public <StudentDto> StudentDto saveStudent(StudentDto studentDto) {

        Student student = studentMapper.fromStudentDtoToStudent((com.example.student.dto.StudentDto) studentDto);
        student = studentRepository.save(student);
        studentDto = (StudentDto) studentMapper.fromStudentToStudentDto(student);
        return studentDto;
    }


    @Override
    public <StudentDto> List<StudentDto> getStudentBydateNaissance(LocalDate dateNaissance) {
        List<Student> students = studentRepository.getStudentBydateNaissance(dateNaissance);
        List<com.example.student.dto.StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(studentMapper.fromStudentToStudentDto(student));
        }
        return (List<StudentDto>) studentDtos;
    }

}
