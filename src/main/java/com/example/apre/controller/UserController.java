package com.example.apre.controller;

import com.example.apre.entity.Users;
import com.example.apre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String user(){
        return "test";
    }

    @PostMapping("/endpoint")
    public Users createdUser(@RequestBody Users users){
        return userRepository.save(users);
    }
}
