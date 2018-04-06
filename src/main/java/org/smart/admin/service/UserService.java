package org.smart.admin.service;

import org.smart.admin.model.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
