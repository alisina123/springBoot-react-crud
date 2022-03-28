package com.example.demo.repository;

import com.example.demo.models.Permission;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    @Query("SELECT u from Permission u where u.id = :id")
    Permission findPermissionById(@Param("id") int id);
}
