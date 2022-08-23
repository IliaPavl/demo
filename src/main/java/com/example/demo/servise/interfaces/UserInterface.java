package com.example.demo.servise.interfaces;

import com.example.demo.entity.UserRole;
import com.example.demo.entity.UserStatus;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserInterface {

    User saveUser(User user);

    User findUser(String userName);

    void deleteUser(User user);

    Page<User> getAllUsers(int page, int howUsers);

    void changeRoleUser(UserRole role, User user);

    void changeStatusUser(UserStatus status, User user);

    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    void createUser(User user);
}
