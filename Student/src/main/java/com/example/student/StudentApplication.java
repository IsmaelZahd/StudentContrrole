package com.example.student;

import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentService studentService){
        return  args -> {
            studentService.saveStudent(
                    StudentDto.builder().name("aaa").email("aaa@bbb.com").dateNaissance(LocalDate.now()).build());
            studentService.saveStudent(
                    StudentDto.builder().name("bbb").email("bbb@ccc.com").dateNaissance(LocalDate.now()).build());
            studentService.saveStudent(
                    StudentDto.builder().name("ccc").email("ccc@ddd.com").dateNaissance(LocalDate.now()).build());
            studentService.saveStudent(
                    StudentDto.builder().name("ddd").email("ddd@eee.com").dateNaissance(LocalDate.now()).build());

        };
    }

}
