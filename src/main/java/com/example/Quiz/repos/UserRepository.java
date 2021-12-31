package com.example.Quiz.repos;

import com.example.Quiz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    public User findByUsername(String username);
    
    public Boolean existsByUsername(String username);
    
    public Boolean existsByEmail(String email);
    
}
