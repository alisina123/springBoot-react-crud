package com.example.demo.repository;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepos extends JpaRepository<Student,Integer> {

    @Query("SELECT u from Student u where u.id = :id")
    Student findStudentById(@Param("id") int id);

}
