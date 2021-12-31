package com.example.Quiz.repos;

import com.example.Quiz.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    public Role findByRolename(String rolename);

}
