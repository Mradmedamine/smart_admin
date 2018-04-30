package org.smart.admin.controller;

import java.util.Locale;

import org.smart.admin.common.validator.UserValidator;
import org.smart.admin.model.entity.User;
import org.smart.admin.service.SecurityService;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("userForm", new User());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "signup";
		}
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		return "redirect:/";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String login(Model model, String error, String logout, Locale locale) {
		Object[] args = new Object[] {};
		if (error != null) {
			String errorMessageCode = error.equals("oauth") ? "common.login.failure"
					: "common.login.invalid.credentials";
			String loginFailureMessage = messageSource.getMessage(errorMessageCode, args, locale);
			model.addAttribute("error", loginFailureMessage);
		}
		if (logout != null) {
			String logoutSuccessMessage = messageSource.getMessage("common.logout.success", args, locale);
			model.addAttribute("message", logoutSuccessMessage);
		}
		return "signin";
	}

}
