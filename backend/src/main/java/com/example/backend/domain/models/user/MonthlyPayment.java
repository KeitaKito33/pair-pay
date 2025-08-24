package com.example.backend.domain.models.user;

import java.math.BigDecimal;
import java.time.YearMonth;

public class MonthlyPayment {
    private final String userId;
    private final int sequenceNumber;
    private final BigDecimal amount;
    private final YearMonth startMonth;
    private final MonthlyPaymentStatus status;
    private final YearMonth endMonth;
    
    public MonthlyPayment(String userId, int sequenceNumber, BigDecimal amount, YearMonth startMonth, MonthlyPaymentStatus status, YearMonth endMonth) {
        this.userId = userId;
        this.sequenceNumber = sequenceNumber;
        this.amount = amount;
        this.startMonth = startMonth;
        this.status = status;
        this.endMonth = endMonth;
    }

    public MonthlyPayment(String userId, int sequenceNumber, BigDecimal amount, YearMonth startMonth, MonthlyPaymentStatus status) {
        this(userId, sequenceNumber, amount, startMonth, status, null);
    }

    public String getUserId() { return userId; }
    public int getSequenceNumber() { return sequenceNumber; }
    public BigDecimal getAmount() { return amount; }
    public YearMonth getStartMonth() { return startMonth;}
    public MonthlyPaymentStatus getStatus() { return status; }
    public YearMonth getEndMonth() { return endMonth; }
}
