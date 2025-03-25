package com.anna.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();

        // todo: Check if email is valid
        // todo: check if email is not taken
        customerRepository.saveAndFlush(customer);// save and flysh in order to have access to customer id
        
        FraudCheckResponse fraudCheckResponse =restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, // response type
                customer.getId());
        // todo: send notification

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }

}
