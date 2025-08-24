package com.example.backend.domain.models.advancepayment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AdvancePayment {
    private final String advancePaymentNumber;
    private final LocalDate advancePaymentDate;
    private final BigDecimal amount;
    private final String title;
    private final String userId;

    public AdvancePayment(String advancePaymentNumber, LocalDate advancePaymentDate, BigDecimal amount, String title, String userId) {
        this.advancePaymentNumber = advancePaymentNumber;
        this.advancePaymentDate = advancePaymentDate;
        this.amount = amount;
        this.title = title;
        this.userId = userId;
    }

    public String getAdvancePaymentNumber() {
        return advancePaymentNumber;
    }
    public LocalDate getAdvancePaymentDate() {
        return advancePaymentDate;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getTitle() {
        return title;
    }
    public String getUserId() {
        return userId;
    }
}