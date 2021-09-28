package ua.ivan.springtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivan.springtask.entity.Notification;
import ua.ivan.springtask.entity.User;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByAddressedUser(User user);
    void deleteAllByAddressedUser(User user);
}
