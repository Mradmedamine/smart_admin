package org.smart.admin.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
@EnableSocial
@PropertySource("classpath:social-cfg.properties")
public class SocialConfig implements SocialConfigurer {

	private boolean autoSignUp = true;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ConnectionSignUp connectionSignUp;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {

		this.autoSignUp = Boolean.parseBoolean(env.getProperty("social.auto-signup"));

		// Twitter
		TwitterConnectionFactory tfactory = new TwitterConnectionFactory(//
				env.getProperty("twitter.consumer.key"), //
				env.getProperty("twitter.consumer.secret"));
		// tfactory.setScope(env.getProperty("twitter.scope"));
		cfConfig.addConnectionFactory(tfactory);

		// Facebook
		FacebookConnectionFactory ffactory = new FacebookConnectionFactory(//
				env.getProperty("facebook.app.id"), //
				env.getProperty("facebook.app.secret"));
		ffactory.setScope(env.getProperty("facebook.scope"));
		// auth_type=reauthenticate
		cfConfig.addConnectionFactory(ffactory);

		// Google
		GoogleConnectionFactory gfactory = new GoogleConnectionFactory(//
				env.getProperty("google.client.id"), //
				env.getProperty("google.client.secret"));
		gfactory.setScope(env.getProperty("google.scope"));
		cfConfig.addConnectionFactory(gfactory);
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository usersConnectionRepository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		if (autoSignUp) {
			usersConnectionRepository.setConnectionSignUp(connectionSignUp);
		} else {
			// After logging in to social networking.
			// If the corresponding APP_USER record is not found.
			// Navigate to registration page.
			usersConnectionRepository.setConnectionSignUp(null);
		}
		return usersConnectionRepository;
	}

	@Bean
	public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator,
			ConnectionRepository connectionRepository) {
		return new ConnectController(connectionFactoryLocator, connectionRepository);
	}

}