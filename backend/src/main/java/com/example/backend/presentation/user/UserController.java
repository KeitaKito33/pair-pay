package com.example.backend.presentation.user;

import com.example.backend.application.user.UserApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping("/{userId}/monthly-payments")
    public ResponseEntity<Void> addMonthlyPayment(
            @PathVariable String userId,
            @RequestBody Map<String, Object> requestBody // ① JSONデータを汎用的なMapとして受け取る
    ) {
        // ② Mapから、キーを指定して手動でデータを取り出す
        BigDecimal amount = new BigDecimal(requestBody.get("amount").toString());
        YearMonth startMonth = YearMonth.parse(requestBody.get("startMonth").toString());

        // ③ 取り出したデータを使って、ApplicationServiceを呼び出す
        userApplicationService.addMonthlyPaymentToUser(
                userId,
                amount,
                startMonth
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}