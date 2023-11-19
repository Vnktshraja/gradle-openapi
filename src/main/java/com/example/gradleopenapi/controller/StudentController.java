package com.example.gradleopenapi.controller;

import com.example.gradleopenapi.DataNotFoundException;
import com.example.gradleopenapi.service.impl.StudentService;
import com.gain.java.knowledge.api.StudentApi;
import com.gain.java.knowledge.api.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
public class StudentController implements StudentApi{
    @Autowired
    private StudentService service;


    @Override
    public ResponseEntity<Void> addStudent(String correlationId, @Valid Student student) {

        return service.addStudent(student);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudent(String correlationId) throws DataNotFoundException{
        List<Student> students = null;
        try{
            students = (List<Student>) service.getAllStudent();
            if(students.isEmpty()){
                throw new DataNotFoundException("DataNotFound");
            }else{
                return new ResponseEntity<>(students,HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public void delete(){
        service.deleteAllStudent();
    }

    @GetMapping("/get")
    public String starting(){
        return "welcome to swagger";
    }
    @PostMapping(value = "/saving",consumes = "application/xml")
    public void postMethod(@RequestBody Student student){
        System.out.println(student.toString());
    }
}
