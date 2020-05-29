package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="payment.amount")
@Data
public class PaymentLimitConfig {
    @JsonProperty("transaction-limit")
    private Long transactionLimit;
    @JsonProperty("daily-limit")
    private Long dailyLimit;
    @JsonProperty("monthly-limit")
    private Long monthlyLimit;
}
