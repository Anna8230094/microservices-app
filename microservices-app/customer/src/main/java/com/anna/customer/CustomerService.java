package com.anna.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void register(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email()).build();
            //todo: Check if email is valid
            //todo: check if email is not taken
            //todo: store customer in database
    }


}
