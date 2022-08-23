package com.example.demo.servise.interfaces;

import com.example.demo.entity.UserStatus;

import java.util.ArrayList;

public interface UserStatusInterface {

    ArrayList<UserStatus> getAllStatus();

    UserStatus getStatus(String name);

    void saveStatus(UserStatus status);

    void updateStatus(String newNameStatus, String oldNameStatus);

    void deleteStatus(UserStatus status);
}
