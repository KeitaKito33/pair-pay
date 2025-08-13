package com.example.backend.domain.user;

public class User {
    private final String userId;
    private final String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getId() { return userId; }
    public String getName() { return userName; }
}
