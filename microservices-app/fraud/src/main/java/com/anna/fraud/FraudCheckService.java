package com.anna.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
       
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()   
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build();
        
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
