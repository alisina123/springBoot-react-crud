package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepos;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    private UserRepos userRepos;
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody User user) {
        HashMap<String, Object> resMap = new HashMap<>();
        try {
            User newUser = userRepos.save(user);
            resMap.put("success", true);
            resMap.put("message", "user created successfully");
            resMap.put("data", newUser);
            return ResponseEntity.ok(resMap);
        } catch (Exception e) {
            log.error("ERROR: {}", e.getMessage());
            resMap.put("success", false);
            resMap.put("data", null);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getStudent() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", userService.getUserList());
        return ResponseEntity.ok(resMap);

    }

    @DeleteMapping("/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        userService.DelelteUser(id);
    }

    @PutMapping
    public ResponseEntity<HashMap<String, Object>> updateUser(@RequestBody User user) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Update User successfully");
        resMap.put("data", userService.updateUser(user));
        return ResponseEntity.ok(resMap);
    }

}
