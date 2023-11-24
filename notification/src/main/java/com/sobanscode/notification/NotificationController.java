package com.sobanscode.notification;

import com.sobanscode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Sending Notification Request for {}", notificationRequest.toCustomerId());
        notificationService.sendNotification(notificationRequest);
    }
}
