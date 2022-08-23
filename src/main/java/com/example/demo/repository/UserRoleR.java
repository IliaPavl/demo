package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleR extends JpaRepository<UserRole, Long> {
    UserRole findByUserRole(String nameRole);
}
