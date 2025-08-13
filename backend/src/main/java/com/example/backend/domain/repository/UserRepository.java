package com.example.backend.domain.repository;

import com.example.backend.domain.model.User;
import java.util.Optional;

public interface UserRepository {
    
    Optional<User> findById(String userId);
    void save(User user);
}
