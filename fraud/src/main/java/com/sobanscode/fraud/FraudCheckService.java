package com.sobanscode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
          FraudCheckHistory.builder()
                  .customerId(customerId)
                  .isFraudster(false)
                  .createdAt(LocalDateTime.now())
                  .build()

        );
        // todo: We can integrate a 3rd party or our own system to check if a customer is Fraudulent
        return false;
    }
}
