package com.sobanscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: check if fraudster
        customerRepository.save(customer);
        // todo: send notification
        /*
          The data directory was initialized by PostgreSQL version 15,
          which is not compatible with this version 16.1 (Debian 16.1-1.pgdg120+1).
         */
    }
}
