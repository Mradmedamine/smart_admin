package org.smart.admin.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.smart.admin.model.ChatBot;
import org.smart.admin.model.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

	@PostMapping("/chat/sendMessage")
	public String sendMessage(ChatMessage chatMessage, Model model) {
		chatMessage.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		model.addAttribute("messages", Arrays.asList(chatMessage, ChatBot.answer(chatMessage)));
		model.addAttribute("suggestions", ChatBot.getSuggestions(chatMessage));
		return "widget/chatMessageWidget::content";
	}

	@PostMapping("/chat/connect")
	public String addUser(ChatMessage chatMessage, HttpServletRequest request, Model model) {
		request.getSession().setAttribute("username", chatMessage.getSender());
		model.addAttribute("messages", Collections.singletonList(ChatBot.answer(chatMessage)));
		model.addAttribute("suggestions", ChatBot.getSuggestions(chatMessage));
		return "widget/chatMessageWidget::content";
	}

}
