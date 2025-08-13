package com.example.backend.presentation.controller;

import com.example.backend.application.service.UserApplicationService;
import com.example.backend.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return userApplicationService.findUser(id)
                .map(ResponseEntity::ok) // ユーザーが見つかれば200 OK
                .orElse(ResponseEntity.notFound().build()); // 見つからなければ404 Not Found
    }
}
