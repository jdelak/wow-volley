package com.delakdev.wvmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delakdev.wvmanager.entities.User;
import com.delakdev.wvmanager.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    // standard constructors
     @Autowired
     UserRepository userRepo;
 
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepo.save(user);
    }
}
