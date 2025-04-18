package com.edunexus.controller;

import com.edunexus.entity.Notification;
import com.edunexus.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @GetMapping("/unread/{userId}")
    public List<Notification> getUnread(@PathVariable int userId) {
        return notificationService.getUnreadNotifications(userId);
    }

    @PutMapping("/read/{id}")
    public void markAsRead(@PathVariable int id) {
        notificationService.markAsRead(id);
    }
}
