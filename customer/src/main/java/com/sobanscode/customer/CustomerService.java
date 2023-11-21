package com.sobanscode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: store customer in DB
        /*
          The data directory was initialized by PostgreSQL version 15,
          which is not compatible with this version 16.1 (Debian 16.1-1.pgdg120+1).
         */
    }
}
