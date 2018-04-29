package org.smart.admin.service;

import org.smart.admin.model.entity.User;
import org.springframework.social.connect.Connection;

public interface UserService {

	User save(User user);

	User saveSocialUser(Connection<?> connection);

	User findByUsername(String username);
}
