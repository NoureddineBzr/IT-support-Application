package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.AdministrateurIT;
import com.example.GestionRessourcesInfo.model.Notification;
import com.example.GestionRessourcesInfo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification creerNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public List<Notification> getUnreadNotificationsForAdmin(AdministrateurIT adminId) {
        return notificationRepository.findByAdministrateurITAndLu(adminId, false);
    }
    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}