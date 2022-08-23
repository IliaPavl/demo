package com.example.demo.servise;

import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleR;
import com.example.demo.servise.interfaces.UserRoleInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRoleService implements UserRoleInterface {
    private final UserRoleR userRoleR;

    @Override
    public ArrayList<UserRole> getAllRole() {
        return (ArrayList<UserRole>) userRoleR.findAll();
    }

    @Override
    public UserRole getRole(String nameRole) {
        return userRoleR.findByUserRole(nameRole);
    }

    @Override
    public UserRole saveRole(UserRole role) {
        userRoleR.save(role);
        return userRoleR.findByUserRole(role.getUserRole());
    }

    @Override
    public void updateRole(String newNameRole, String oldNameRole) {
        UserRole role = userRoleR.findByUserRole(oldNameRole);
        role.setUserRole(newNameRole);
    }


    @Override
    public void deleteRole(UserRole role) {
        userRoleR.delete(role);
    }
}
