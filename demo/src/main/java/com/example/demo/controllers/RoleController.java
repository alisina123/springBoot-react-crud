package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.models.Student;
import com.example.demo.models.User;
import com.example.demo.repository.RoleRepos;
import com.example.demo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/role")
public class RoleController {
    private RoleRepos roleRepos;
    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> createRole(@RequestBody Role role) {
        HashMap<String, Object> resMap = new HashMap<>();
        try {
            Role createRole = roleService.roleRegister(role);
            resMap.put("success", true);
            resMap.put("message", "role created successfully");
            resMap.put("data", createRole);
            //return ResponseEntity.created();
            return ResponseEntity.ok(resMap);
        } catch (Exception e) {
            log.error("ERROR: {}", e.getMessage());
            resMap.put("success", false);
            resMap.put("data", null);
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getRole() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", roleService.getRoleList());
        return ResponseEntity.ok(resMap);

    }

    @DeleteMapping("/{id}")
    private void deleteRole(@PathVariable("id") int id) {
        roleService.DelelteRole(id);
    }

    @PutMapping
    public ResponseEntity<HashMap<String, Object>> updateRole(@RequestBody Role role) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Update Role successfully");
        resMap.put("data", roleService.updateRole(role));
        return ResponseEntity.ok(resMap);
    }

}
