package com.example.demo.servise.interfaces;

import com.example.demo.entity.UserRole;

import java.util.ArrayList;

public interface UserRoleInterface {

    ArrayList<UserRole> getAllRole();

    UserRole getRole(String name);

    UserRole saveRole(UserRole role);

    void updateRole(String newNameRole, String oldNameRole);

    void deleteRole(UserRole role);
}
