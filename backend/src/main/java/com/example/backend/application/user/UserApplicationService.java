package com.example.backend.application.user;

import com.example.backend.domain.user.User;
import com.example.backend.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.YearMonth;

@Service
public class UserApplicationService {

    private final UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addMonthlyPaymentToUser(String userId, BigDecimal amount, YearMonth startMonth) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("対象のユーザーが見つかりません。 ID: " + userId));

        user.addMonthlyPayment(amount, startMonth);
        userRepository.save(user);
    }
}