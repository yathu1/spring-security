package com.yathu.spring_boot_security.controllers;


import com.yathu.spring_boot_security.entity.UserEntity;
import com.yathu.spring_boot_security.exceptions.ResourceNotFoundException;
import com.yathu.spring_boot_security.models.User;
import com.yathu.spring_boot_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

         @Autowired
        private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getUsers() {
//        return Arrays.asList(new User(1L, "john_doe", "john@gmail.com"),
//                new User(2L, "jane_doe", "jane2gmail.com"),
//                new User(3L, "_smith", "aljioi@gmail.com"));
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

}
