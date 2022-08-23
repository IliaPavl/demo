package com.example.demo.repository;

import com.example.demo.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusR extends JpaRepository<UserStatus, Long> {
    UserStatus findByUserStatus(String nameStatus);
}
