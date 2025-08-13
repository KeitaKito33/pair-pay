package com.example.backend.infrastructure.repository;

import com.example.backend.domain.user.User;
import com.example.backend.domain.user.UserRepository;

import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepositoryImpl {
        private final Map<Long, User> store = new ConcurrentHashMap<>();

    public InMemoryUserRepositoryImpl() {
        // ダミーデータ
        store.put(1L, new User(1L, "Taro Yamada"));
        store.put(2L, new User(2L, "Hanako Suzuki"));
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
