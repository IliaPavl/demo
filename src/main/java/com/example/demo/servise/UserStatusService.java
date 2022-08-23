package com.example.demo.servise;

import com.example.demo.entity.UserStatus;
import com.example.demo.repository.UserStatusR;
import com.example.demo.servise.interfaces.UserStatusInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class UserStatusService implements UserStatusInterface {

    private final UserStatusR userStatusR;

    @Override
    public ArrayList<UserStatus> getAllStatus() {
        return (ArrayList<UserStatus>) userStatusR.findAll();
    }

    @Override
    public UserStatus getStatus(String nameStatus) {
        return userStatusR.findByUserStatus(nameStatus);
    }

    @Override
    public void saveStatus(UserStatus status) {
        userStatusR.save(status);
    }

    @Override
    public void updateStatus(String newNameStatus, String oldNameStatus) {
        UserStatus userStatus= userStatusR.findByUserStatus(oldNameStatus);
        userStatus.setUserStatus(newNameStatus);
    }

    @Override
    public void deleteStatus(UserStatus status) {
        userStatusR.delete(status);
    }
}
