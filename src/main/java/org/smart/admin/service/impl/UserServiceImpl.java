package org.smart.admin.service.impl;

import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.entity.User;
import org.smart.admin.repository.RoleRepository;
import org.smart.admin.repository.UserRepository;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User user) {
		logger.debug("saving new user with Username : {}, email {}", user.getUsername(), user.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		logger.debug("findByUsername {}", username);
		return userRepository.findByUsername(username);
	}

	@Override
	public User saveSocialUser(Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		User user = this.findByUsername(userProfile.getUsername());
		if (user == null) {
			user = new User();
			user.setFullname(userProfile.getFirstName() + " " + userProfile.getLastName());
			user.setUsername(userProfile.getEmail());
			user.setEmail(userProfile.getEmail());
			String randomPassword = UUID.randomUUID().toString().substring(0, 5);
			user.setPassword(randomPassword);
			user.setPasswordConfirm(randomPassword);
			logger.debug("saving social user {}", user.toString());
			this.save(user);
		}
		return user;
	}
}
