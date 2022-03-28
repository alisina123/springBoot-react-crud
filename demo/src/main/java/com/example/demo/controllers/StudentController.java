package com.example.demo.controllers;


import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepos;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/students")
public class StudentController {
    private StudentRepos studentRepos;
    @Autowired
    StudentService studentService;
    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getStudents() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", studentService.getStudent());
        return ResponseEntity.ok(resMap);

    }
    @PostMapping
    public ResponseEntity<HashMap<String, Object>> rgister(@RequestBody Student student) {
        Student studentRegister = studentService.register(student);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", studentRegister);
        return ResponseEntity.ok(resMap);
    }
    @PutMapping
    public ResponseEntity<HashMap<String, Object>> updateStudent(@RequestBody Student student) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", studentService.updateStudent(student));
        return ResponseEntity.ok(resMap);
    }
    @DeleteMapping("/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        studentService.DeleteSt(id);
    }
    @GetMapping("{id}")
    public ResponseEntity<HashMap<String, Object>> findStudentById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Student By Id");
        resMap.put("data", studentService.findStudent(id));
        return ResponseEntity.ok(resMap);
    }
}
