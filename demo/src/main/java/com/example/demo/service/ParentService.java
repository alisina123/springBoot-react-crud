package com.example.demo.service;


import com.example.demo.models.Parent;
import com.example.demo.repository.ParentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    ParentRepos parentRepos;

    public Parent parentRegtister(Parent parent) {
        return parentRepos.save(parent);
    }

    public List<Parent> getAllParents() {
        return parentRepos.findAll();
    }

    public void delelteParent(int parentId) {
        parentRepos.deleteById(parentId);
    }

    public Parent findParentById(int parentId) {
        try {
            return parentRepos.findParentById(parentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
