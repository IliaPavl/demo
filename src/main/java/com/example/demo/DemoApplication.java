package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserR userR;

    @Autowired
    private UserRoleR userRoleR;

    @Autowired
    private UserStatusR userStatusR;

    @Autowired
    private ClientStatusR clientStatusR;

    @Autowired
    private ClientsR clientsR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    protected void init() {

//        if (userRoleR.findById(1L).isEmpty())
//            userRoleR.save(new UserRole(1L, "Admin"));
//        if (userRoleR.findById(2L).isEmpty())
//            userRoleR.save(new UserRole(2L, "User"));
//
//        if (userStatusR.findById(1L).isEmpty())
//            userStatusR.save(new UserStatus(1L, "Active"));
//        if (userStatusR.findById(2L).isEmpty())
//            userStatusR.save(new UserStatus(2L, "NoActive"));
//
//        if (clientStatusR.findById(1L).isEmpty())
//            clientStatusR.save(new ClientStatus(1L, "Active"));
//        if (clientStatusR.findById(2L).isEmpty())
//            clientStatusR.save(new ClientStatus(2L, "NoActive"));

//        for (long i = 1; i < 50; i++) {
//            if (clientsR.findById(i).isEmpty()) {
//                clientsR.save(new Clients(i, "Name" + i, "FullName" + i, "Number" + i, new Date(), clientStatusR.findById(1L).get()));
//                userR.save(new User(i, clientsR.findById(i).get(), userRoleR.findById(1L).get(), userStatusR.findById(1L).get(), "FIO" + i, "LOGIN" + i, passwordEncoder.encode("123"), "EMAIL" + i, "LINK" + i));
//            }
//        }

    }
}
