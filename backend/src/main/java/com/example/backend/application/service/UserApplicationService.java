package com.example.backend.application.service;

import com.example.backend.domain.user.User;
import com.example.backend.domain.user.UserRepository;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserApplicationService {
    private final UserRepository userRepository;

    // UserRepositoryの「実装」ではなく「インターフェース」に依存するのがポイント
    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }
}
