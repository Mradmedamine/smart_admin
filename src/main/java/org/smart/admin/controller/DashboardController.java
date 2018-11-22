package org.smart.admin.controller;

import org.smart.admin.common.util.SecurityUtils;
import org.smart.admin.repository.DepartmentRepository;
import org.smart.admin.repository.NotificationRepository;
import org.smart.admin.service.CommuneService;
import org.smart.admin.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

	@Autowired
	private CommuneService communeService;

	@Autowired
	private NotificationRepository notificationRepo;

	@Autowired
	private MailService mailService;
	
	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("department", DepartmentRepository.getDepartment("01"));
		return "index";
	}

	@GetMapping({ "/contact/{insee}" })
	public String contact(@PathVariable String insee, String success, Model model) {
		model.addAttribute("insee", insee);
		if (success != null) {
			model.addAttribute("message", "message envoyé !");
		}
		return "contact";
	}

	@PostMapping({ "/contact/{insee}" })
	public String sendMessage(@PathVariable String insee, String body, Model model) {
		mailService.sendSignalMail(body, insee);
		return "redirect:/contact?success=true";
	}

	@GetMapping("/department/info/{departmentCode}")
	public String getDepartmentInfo(@PathVariable String departmentCode, Model model) {
		model.addAttribute("department", DepartmentRepository.getDepartment(departmentCode));
		return "widget/departmentInfoWidget";
	}

	@GetMapping("/department/communes/{departmentCode}")
	public String getCommunesWidget(@PathVariable String departmentCode, Model model) {
		model.addAttribute("department", DepartmentRepository.getDepartment(departmentCode));
		return "widget/communesWidget";
	}

	@GetMapping("/selection/{departmentCode}/{inseeCommune}")
	public String selection(@PathVariable String departmentCode, @PathVariable String inseeCommune, Model model) {
		model.addAttribute("commune", DepartmentRepository.getTownship(departmentCode, inseeCommune));
		model.addAttribute("communeInfo", communeService.findByInsee(departmentCode));
		return "selection";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("notifs", notificationRepo.findByUser_Username(SecurityUtils.findLoggedInUsername()));
	}

}
