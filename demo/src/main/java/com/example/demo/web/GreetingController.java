package com.example.demo.web;

import com.example.demo.dto.PaymentLimitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class GreetingController {
    @Value("${greeting.message}")
    private String message;

    @Autowired
    private PaymentLimitConfig paymentLimitConfig;


    @GetMapping
    public String getMessage(){
        log.info("Responding with message {}", message);
        return message;
    }

    @GetMapping("/config")
    public PaymentLimitConfig getConfig(){
        log.info("per transaction limit is {}", paymentLimitConfig.getTransactionLimit());
        log.info("daily transaction limit is {}", paymentLimitConfig.getDailyLimit() );
        log.info("monthly transaction limit is {}", paymentLimitConfig.getMonthlyLimit() );
        return paymentLimitConfig;
    }

}
