package ua.ivan.springtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivan.springtask.entity.Notification;
import ua.ivan.springtask.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {
    private NotificationRepository notificationRepository;
    private UserService userService;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository,
                               UserService userService) {
        this.notificationRepository = notificationRepository;
        this.userService = userService;
    }

    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    public List<Notification> getCurrentUserNotifications() {
        return notificationRepository
                .findAllByAddressedUser(
                        userService.getCurrentUser());
    }

    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }
}
