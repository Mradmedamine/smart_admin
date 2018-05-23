package org.smart.admin.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.smart.admin.common.Constants;
import org.smart.admin.model.ChatMessage.MessageType;

public final class ChatBot {

	private ChatBot() {
	}

	public static ChatMessage answer(ChatMessage message) {
		ChatMessage answer = new ChatMessage();
		answer.setSender("Smart Admin");
		answer.setType(MessageType.CHAT);
		answer.setContent(lookupAnswer(message));
		answer.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		return answer;
	}

	public static List<String> getSuggestions(ChatMessage message) {
		if (message.getType() == MessageType.JOIN) {
			return Arrays.asList(Constants.BotMessages.QUESTION_REGISTER, Constants.BotMessages.QUESTION_CREATE_DOSSIER,
					Constants.BotMessages.QUESTION_DEPARTMENT, Constants.BotMessages.QUESTION_COMMUNE);
		}
		return Collections.emptyList();
	}

	private static String lookupAnswer(ChatMessage message) {
		if (message.getType() == MessageType.JOIN) {
			return String.format(Constants.BotMessages.WELCOME_MESSAGE, message.getSender());
		} else {
			switch (message.getContent()) {
			case Constants.BotMessages.QUESTION_REGISTER:
				return Constants.BotMessages.ANSWER_REGISTER;
			case Constants.BotMessages.QUESTION_CREATE_DOSSIER:
				return Constants.BotMessages.ANSWER_CREATE_DOSSIER;
			case Constants.BotMessages.QUESTION_DEPARTMENT:
				return Constants.BotMessages.ANSWER_DEPARTMENT;
			case Constants.BotMessages.QUESTION_COMMUNE:
				return Constants.BotMessages.ANSWER_COMMUNE;
			}
			return "Quoi ?! ";
		}
	}

}
