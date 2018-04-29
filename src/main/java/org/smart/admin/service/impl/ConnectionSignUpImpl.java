package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.entity.User;
import org.smart.admin.service.SecurityService;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

@Component
public class ConnectionSignUpImpl implements ConnectionSignUp {

	private final Logger logger = LoggerFactory.getLogger(ConnectionSignUp.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Override
	public String execute(Connection<?> connection) {
		logger.debug("executing social signUp, connection {}", connection.toString());
		User user = userService.saveSocialUser(connection);
		securityService.autologin(user.getUsername(), user.getPasswordConfirm());
		return user.getUsername();
	}

}