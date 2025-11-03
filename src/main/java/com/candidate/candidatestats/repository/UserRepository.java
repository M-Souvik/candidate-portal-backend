package com.candidate.candidatestats.repository;

import com.candidate.candidatestats.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
