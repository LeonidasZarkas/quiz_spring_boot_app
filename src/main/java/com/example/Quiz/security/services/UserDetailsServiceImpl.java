package com.example.Quiz.security.services;

import com.example.Quiz.models.User;
import com.example.Quiz.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User u = userRepository.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found");
        }

        return new UserDetailsImpl(u);
    }

}
