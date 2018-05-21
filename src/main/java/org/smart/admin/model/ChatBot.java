package org.smart.admin.model;

import org.smart.admin.common.Constants;
import org.smart.admin.model.ChatMessage.MessageType;

public final class ChatBot {

	private ChatBot() {
	}

	public static ChatMessage answer(ChatMessage message) {
		ChatMessage answer = new ChatMessage();
		answer.setSender("Bot");
		answer.setType(MessageType.CHAT);
		answer.setContent(lookupAnswer(message));
		return answer;
	}

	private static String lookupAnswer(ChatMessage message) {
		if (message.getType() == MessageType.JOIN) {
			return Constants.BotMessages.WELCOME_MESSAGE + message.getSender();
		} else {
			return "Sounds goods, check here ";
		}
	}

}
