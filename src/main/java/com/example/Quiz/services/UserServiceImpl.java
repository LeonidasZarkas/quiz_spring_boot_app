package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.User;
import com.example.Quiz.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserServiceInterface{
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }


    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}
