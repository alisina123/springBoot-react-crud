package com.example.demo.service;
import com.example.demo.models.Student;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepos userRepos;
    public User userRegister(User user)
    {
        return userRepos.save(user);

    }
    public List<User> getUserList()
    {
        try {

            return userRepos.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public User updateUser(User user) {
        int userId =  user.getId();
        try {
            User updateUser = userRepos.findUserById(userId);
            if (updateUser != null) {
                updateUser = user;
                return userRepos.save(user);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void DelelteUser(int userId)
    {
        userRepos.deleteById(userId);
    }
}
