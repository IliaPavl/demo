package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.UserStatus;
import com.example.demo.servise.UserRoleService;
import com.example.demo.servise.UserService;
import com.example.demo.servise.UserStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRoleService roleService;
    private final UserStatusService statusService;

    @GetMapping()
    public ResponseEntity<User> geAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(userService.findUser(auth.getName()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/all/{page}/{how}")
    public ResponseEntity<Page<User>> getUsers(@PathVariable("page") String page,@PathVariable("how") String how) {
        return ResponseEntity.ok().body(userService.getAllUsers(Integer.parseInt(page), Integer.parseInt(how)));
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<ArrayList<UserRole>> saveUserRole(@RequestBody UserRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/role/save").toUriString());
        roleService.saveRole(role);
        return ResponseEntity.created(uri).body(roleService.getAllRole());
    }

    @GetMapping("/role/all")
    public ResponseEntity<ArrayList<UserRole>> allUserRole() {
        return ResponseEntity.ok().body(roleService.getAllRole());
    }

    @GetMapping("/status/all")
    public ResponseEntity<ArrayList<UserStatus>> allUserStatus() {
        return ResponseEntity.ok().body(statusService.getAllStatus());
    }

    @PostMapping("/status/save")
    public ResponseEntity<ArrayList<UserStatus>> saveUserStatus(@RequestBody UserStatus userStatus) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/status/save").toUriString());
        statusService.saveStatus(userStatus);
        return ResponseEntity.created(uri).body(statusService.getAllStatus());
    }


}
