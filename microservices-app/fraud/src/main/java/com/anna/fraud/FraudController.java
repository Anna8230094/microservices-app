package com.anna.fraud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    
    private final FraudCheckService fraudCheckService;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
       boolean isFraudulentCusstomer = fraudCheckService.isFraudulentCustomer(customerId);
       log.info("fraud check request for customer {}", customerId);
       return new FraudCheckResponse(isFraudulentCusstomer);
    }
}
