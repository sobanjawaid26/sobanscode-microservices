package com.sobanscode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService
                .isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
