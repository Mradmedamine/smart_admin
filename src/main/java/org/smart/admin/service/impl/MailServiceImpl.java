package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	public void sendMail(String from, String to, String subject, String body) {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);

		logger.info("Sending...");

		javaMailSender.send(mail);

		logger.info("Done!");
	}

	@Override
	public void sendSignalMail(String body, String insee) {
		sendMail("eva.anter1992@gmail.com", "mradmohamedamine@gmail.com",
				"Réclamation: Smart Admin: Prefecture INSEE : " + insee, body);
	}

}
