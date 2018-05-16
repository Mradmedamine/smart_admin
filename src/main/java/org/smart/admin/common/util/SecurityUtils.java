package org.smart.admin.common.util;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

	public static String findLoggedInUsername() {
		return findLoggedInUser().map(UserDetails::getUsername).orElse(null);
	}

	public static Optional<UserDetails> findLoggedInUser() {
		Object userDetails = SecurityUtils.getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return Optional.of((UserDetails) userDetails);
		}
		return Optional.empty();
	}

	private static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
