package com.example.demo.controllers;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    @GetMapping()
    public String test(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "user:  "+ auth.getName() + " is authorized!";
    }
}
