package com.example.apre.service.impl;

import com.example.apre.entity.Users;
import com.example.apre.repository.UserRepository;
import com.example.apre.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
}
