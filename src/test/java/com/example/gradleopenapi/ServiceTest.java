package com.example.gradleopenapi;

import com.example.gradleopenapi.controller.StudentController;
import com.example.gradleopenapi.service.impl.StudentServiceImpl;
import com.gain.java.knowledge.api.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.meta.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class ServiceTest {

    @MockBean
    private StudentServiceImpl studentService;
    @Autowired
    private StudentController studentController;

    @Test
    public void getAllTest(){
        Student student = new Student();
        student.setId(1);
        student.setName("venkat");
        student.setCity("chennai");
        List<Student> list = new ArrayList<>();
        list.add(student);
        Mockito.when(studentService.getAllStudent()).thenReturn(list);
        ResponseEntity<List<Student>> response = studentController.getAllStudent("123456");
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void getAllTestNegative(){
        Mockito.when(studentService.getAllStudent()).thenReturn(null);
        ResponseEntity<List<Student>> response = studentController.getAllStudent("123456");
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

//    @Test
//    public void getAllTestNegativeForThrow(){
//        List<Student> list = new ArrayList<>();
//        Mockito.when(studentService.getAllStudent()).thenReturn(list);
//        assertThrows(DataNotFoundException.class, () -> {
//            studentController.getAllStudent("123456");
//        });
//    }


}
