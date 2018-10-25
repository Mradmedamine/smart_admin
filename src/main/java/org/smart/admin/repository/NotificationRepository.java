package org.smart.admin.repository;

import java.util.List;

import org.smart.admin.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByUser_Username(String username);
}
