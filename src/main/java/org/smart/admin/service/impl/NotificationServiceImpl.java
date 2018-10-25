package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.entity.Notification;
import org.smart.admin.repository.NotificationRepository;
import org.smart.admin.service.NotificationService;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public void save(Notification notification) {
		notificationRepository.save(notification);
	}
  
}
