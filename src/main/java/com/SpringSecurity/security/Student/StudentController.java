package com.SpringSecurity.security.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;



    @RequestMapping("api/v1/students")
    public class StudentController {

        private static final List<Student> STUDENTS = Arrays.asList(
                new Student(1, "Daphne"),
                new Student(2, "Ruth"),
                new Student(3, "Anna ")
        );

        @GetMapping(path = "{studentId}")
        public Student getStudent(@PathVariable("studentId") Integer studentId) {
            return STUDENTS.stream()
                    .filter(student -> studentId.equals(student.getStudentId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(
                            "Student " + studentId + " does not exists"
                    ));
        }
    }

