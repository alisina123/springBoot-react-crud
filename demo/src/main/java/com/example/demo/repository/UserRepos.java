package com.example.demo.repository;

import com.example.demo.models.Student;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepos extends JpaRepository<User,Integer> {
    @Query("SELECT u from User u where u.id = :id")
    User findUserById(@Param("id") int id);

}
