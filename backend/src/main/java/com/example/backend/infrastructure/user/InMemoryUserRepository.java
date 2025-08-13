package com.example.backend.infrastructure.user;

import com.example.backend.domain.user.User;
import com.example.backend.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepository implements UserRepository {

    // データベースの代わりとなる、メモリ上のデータ保管庫を作成
    private final Map<String, User> store = new ConcurrentHashMap<>();

    // テスト用のダミーデータをデータ保管庫に追加
    public InMemoryUserRepository() {
        User user1 = new User("user-001", "Taro Yamada", new ArrayList<>());
        store.put(user1.getUserId(), user1);
    }

    @Override
    public Optional<User> findById(String userId) {
        User user = store.get(userId);
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        store.put(user.getUserId(), user);
    }
}