package com.sobanscode.notification;

import com.sobanscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Boolean sendNotification(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification
                        .builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .message(notificationRequest.message())
                        .sender(notificationRequest.sender())
                        .sentAt(notificationRequest.sentAt())
                        .build()
        );
        return true;
    }
}
