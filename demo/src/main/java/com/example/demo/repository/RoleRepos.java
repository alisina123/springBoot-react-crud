package com.example.demo.repository;

import com.example.demo.models.Role;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepos extends JpaRepository<Role, Integer> {
    @Query("SELECT u from Role u where u.id = :id")
    Role findRoleById(@Param("id") int id);
}
