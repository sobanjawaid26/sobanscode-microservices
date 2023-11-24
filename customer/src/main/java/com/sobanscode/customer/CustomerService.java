package com.sobanscode.customer;

import com.sobanscode.clients.fraud.FraudCheckResponse;
import com.sobanscode.clients.fraud.FraudClient;
import com.sobanscode.clients.notification.NotificationClient;
import com.sobanscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.management.Notification;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        /*
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
         */

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        // todo: Make it async, add it to queue
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        "Sobanscode",
                        String.format("Hi %s, Welcome to Sobanscode"), customer.getFirstName(),
                        LocalDateTime.now())
        );
        /*
          The data directory was initialized by PostgreSQL version 15,
          which is not compatible with this version 16.1 (Debian 16.1-1.pgdg120+1).
         */
    }
}
