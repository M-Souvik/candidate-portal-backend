package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.model.Users;
import com.candidate.candidatestats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://candidate-portal-frontend.vercel.app", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        try {
            System.out.print("user:"+user);
            Users savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
