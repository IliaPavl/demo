package com.example.demo.servise;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.UserStatus;
import com.example.demo.repository.UserR;
import com.example.demo.servise.interfaces.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserInterface {

    private final UserR userR;

    @Override
    public User saveUser(User user) {
        userR.save(user);
        return user;
    }

    @Override
    public User findUser(String login) {
        return userR.findByUserLogin(login);
    }

    @Override
    public void deleteUser(User user) {
        userR.delete(user);
    }

    @Override
    public Page<User> getAllUsers(int page, int howUsers) {
        Pageable pageable = PageRequest.of(page, howUsers);
        return userR.findAll(pageable);
    }
    public List<User> getAllUsers() {
        return userR.findAll();
    }

    @Override
    public void changeRoleUser(UserRole role, User user) {
        user.setUserRole(role);
    }

    @Override
    public void changeStatusUser(UserStatus status, User user) {
        user.setUserStatus(status);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userR.findByUserLogin(login);
        if (user == null)
            throw new UsernameNotFoundException("User " + login + "not found");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole().getUserRole()));
        return new org.springframework.security.core.userdetails.User(user.getUserLogin(), user.getPassword(), authorities);
    }

    @Override
    public void createUser(User user) {

    }
}
