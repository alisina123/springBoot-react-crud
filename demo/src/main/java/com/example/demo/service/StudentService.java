package com.example.demo.service;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepos studentRepos;

    public Student register(Student student) {
        return studentRepos.save(student);
    }

    public List<Student> getStudent() {
        return studentRepos.findAll();
    }

    public void DeleteSt(int id) {
        studentRepos.deleteById(id);
    }

    public Student updateStudent(Student student) {
        int studentId = student.getId();
        try {
            Student updateStudent = studentRepos.findStudentById(studentId);
            if (updateStudent != null) {
                updateStudent = student;
                return studentRepos.save(student);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student findStudent(int studentId) {
        try {
            return studentRepos.findStudentById(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
