package com.example.demo.repository;

import com.example.demo.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParentRepos extends JpaRepository<Parent,Integer> {
    @Query("SELECT p from Parent p where p.id = :id")
    Parent findParentById(@Param("id") int id);
}
