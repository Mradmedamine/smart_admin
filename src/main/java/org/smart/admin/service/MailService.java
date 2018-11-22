package org.smart.admin.service;

public interface MailService {

	void sendMail(String from, String to, String subject, String body);

	void sendSignalMail(String body, String insee);

}
