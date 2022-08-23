package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserR extends JpaRepository<User, Long> {
    User findByUserLogin(String login);
}
