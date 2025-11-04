package com.candidate.candidatestats.controller;

import com.candidate.candidatestats.model.Users;
import com.candidate.candidatestats.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://candidate-portal-frontend.vercel.app", allowCredentials = "true")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @PostMapping("/login")
   @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Users request, HttpSession session) {
    Optional<Users> userOpt = userRepository.findByUsername(request.getUsername());

    if (userOpt.isPresent() && passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
        Users user = userOpt.get();

        // ✅ Create authentication token
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), null, Collections.emptyList());

        SecurityContextHolder.getContext().setAuthentication(authToken);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        session.setAttribute("user", user); // optional

        return ResponseEntity.ok(Map.of(
            "message", "Login successful",
            "username", user.getUsername()
        ));
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(Map.of("error", "Invalid username or password"));
}

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of(
            "message", "Logout successful"
            // "username", user.getUsername()
        ));
    }

    @GetMapping("/check")
    public Object checkSession(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) return user;
        return "No active session";
    }
}
