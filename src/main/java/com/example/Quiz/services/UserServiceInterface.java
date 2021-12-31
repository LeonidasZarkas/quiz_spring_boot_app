package com.example.Quiz.services;

import com.example.Quiz.models.User;
import java.util.List;

public interface UserServiceInterface {
    
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public void createUser(User user);
    public void deleteUserById(Integer id);
}
