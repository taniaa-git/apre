package com.example.apre.service;

import com.example.apre.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
