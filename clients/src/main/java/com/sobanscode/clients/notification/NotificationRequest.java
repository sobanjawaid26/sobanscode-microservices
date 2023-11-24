package com.sobanscode.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String sender,
        String message,
        String firstName, LocalDateTime sentAt) {
}
