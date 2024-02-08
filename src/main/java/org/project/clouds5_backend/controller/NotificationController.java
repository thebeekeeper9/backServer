package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.NotificationMessage;
import org.project.clouds5_backend.service.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    final
    FirebaseMessagingService firebaseMessagingService;

    public NotificationController(FirebaseMessagingService firebaseMessagingService) {
        this.firebaseMessagingService = firebaseMessagingService;
    }

    @PostMapping
    public String sendNotificationByToken(@RequestBody NotificationMessage notificationMessage)
            throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotification(notificationMessage);
    }

}
