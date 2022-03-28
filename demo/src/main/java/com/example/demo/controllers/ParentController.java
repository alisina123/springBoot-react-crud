package com.example.demo.controllers;

import com.example.demo.models.Parent;
import com.example.demo.models.User;
import com.example.demo.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value = "/parent")
public class ParentController {

    @Autowired
    ParentService parentService;
    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getAllParent() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All Parent list");
        resMap.put("data", parentService.getAllParents());
        return ResponseEntity.ok(resMap);

    }
    @PostMapping
    public ResponseEntity<HashMap<String, Object>> parentRegister(@RequestBody Parent parent) {
        Parent parentRegister = parentService.parentRegtister(parent);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All Parent list");
        resMap.put("data", parentRegister);
        return ResponseEntity.ok(resMap);
    }
    @DeleteMapping("/{id}")
    public void delelteParent(@PathVariable("id") int id)
    {
        parentService.delelteParent(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> findParentById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "ParentBYId ");
        resMap.put("data", parentService.findParentById(id));
        return ResponseEntity.ok(resMap);
    }

}
