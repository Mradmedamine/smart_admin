package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SocialUserDetailsServiceImpl implements SocialUserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(SocialUserDetailsService.class);

	@Autowired
	private UserDetailsService userDetailsServiceImpl;

	@Override
	public SocialUserDetails loadUserByUserId(String userName) throws UsernameNotFoundException, DataAccessException {
		logger.debug("loading Social User By UserId {}", userName);
		UserDetails userDetails = ((UserDetailsServiceImpl) userDetailsServiceImpl).loadUserByUsername(userName);
		return (SocialUser) userDetails;
	}

}