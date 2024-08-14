package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.AdministrateurIT;
import com.example.GestionRessourcesInfo.model.Notification;
import com.example.GestionRessourcesInfo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/addNot")
    public ResponseEntity<Notification> creerNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.creerNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/admin/{adminId}/unread")
    public ResponseEntity<List<Notification>> getUnreadNotificationsForAdmin(@PathVariable AdministrateurIT adminId) {
        List<Notification> notifications = notificationService.getUnreadNotificationsForAdmin(adminId);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        notification.setId(id);
        Notification updatedNotification = notificationService.updateNotification(notification);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
