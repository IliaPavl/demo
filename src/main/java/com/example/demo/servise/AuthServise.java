package com.example.demo.servise;

import com.example.demo.entity.User;
import com.example.demo.repository.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServise implements UserDetailsService {


    @Autowired
    private UserR userR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userR.findByUserLogin(username);
        if(null== user){
            throw new UsernameNotFoundException("User not found:"+username);
        }
        return user;
    }
}
