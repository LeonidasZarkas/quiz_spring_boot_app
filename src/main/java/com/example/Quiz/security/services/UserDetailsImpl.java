package com.example.Quiz.security.services;

import com.example.Quiz.models.User;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> result = new ArrayList<>();
        result.add(new SimpleGrantedAuthority(user.getUserrole().getRolename()));
        return result;
    }

    @Override
    public String getPassword() {
        return user.getUserpassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
    public String getEmail() {
        return user.getEmail();
    }
    
    public Integer getUserid() {
        return user.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
