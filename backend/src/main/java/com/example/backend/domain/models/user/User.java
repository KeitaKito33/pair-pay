package com.example.backend.domain.models.user;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final String userId;
    private final String userName;
    private final List<MonthlyPayment> monthlyPayments; // ここに月次負担額を保持することで、ユーザを集約ルートとする

    public User(String userId, String userName, List<MonthlyPayment> monthlyPayments) {
        this.userId = userId;
        this.userName = userName;
        this.monthlyPayments = new ArrayList<>(monthlyPayments);
    }

    public void addMonthlyPayment(BigDecimal amount, YearMonth startMonth) {
        boolean alreadyHasAppliedPayment = this.monthlyPayments.stream()
                .anyMatch(payment -> payment.getStatus() == MonthlyPaymentStatus.APPLIED);

        if (alreadyHasAppliedPayment) {
            throw new IllegalStateException("適用中の月次負担額が既に存在するため、新しい負担額を追加できません。");
        }

        // チェックを通過した場合のみ、以下の処理が実行される
        int newSequenceNumber = this.monthlyPayments.size() + 1;

        MonthlyPayment newPayment = new MonthlyPayment(
            this.userId,
            newSequenceNumber,
            amount,
            startMonth,
            MonthlyPaymentStatus.APPLIED,
            null
        );

        this.monthlyPayments.add(newPayment);
    }

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public List<MonthlyPayment> getMonthlyPayments() {
        return Collections.unmodifiableList(monthlyPayments);
    }
}
