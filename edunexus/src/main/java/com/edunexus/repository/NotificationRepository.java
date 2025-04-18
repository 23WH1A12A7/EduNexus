package com.edunexus.repository;

import com.edunexus.entity.Notification;
import com.edunexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserAndIsReadFalse(User user);
}
