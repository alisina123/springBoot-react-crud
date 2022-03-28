package com.example.demo.service;

import com.example.demo.models.Permission;
import com.example.demo.models.User;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;
    public Permission permissionRegister(Permission permission)
    {
        return permissionRepository.save(permission);

    }
    public List<Permission> getPermissionList()
    {
        try {

            return permissionRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public Permission updatePermission(Permission permission) {
        int permissionId =  permission.getId();
        try {
            Permission updatePermission = permissionRepository.findPermissionById(permissionId);
            if (updatePermission != null) {
                updatePermission = permission;
                return permissionRepository.save(permission);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void DeleltePermission(int permissionId)
    {
        permissionRepository.deleteById(permissionId);
    }

}
