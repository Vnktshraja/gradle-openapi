package com.example.gradleopenapi.controller;

import com.example.gradleopenapi.service.impl.StudentService;
import com.gain.java.knowledge.api.StudentApi;
import com.gain.java.knowledge.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController implements StudentApi{
    @Autowired
    private StudentService service;


    @Override
    public ResponseEntity<Void> addStudent(String correlationId, @Valid Student student) {
        return service.addStudent(student);
    }

    @Override
    public ResponseEntity<
            List<Student>> getAllStudent(String correlationId) {
        return service.getAllStudent();
    }

    @GetMapping("/")
    public String starting(){
        return "welcome to swagger";
    }
}
