package com.example.backend.domain.repository;

import java.util.Optional;

import com.example.backend.domain.models.user.User;

public interface UserRepository {
    
    Optional<User> findById(String userId);
    void save(User user);
}
