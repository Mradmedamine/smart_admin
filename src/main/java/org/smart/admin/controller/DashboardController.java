package org.smart.admin.controller;

import org.smart.admin.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("department", DepartmentRepository.getDepartment("01"));
		return "index";
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
		return "selection";
	}
		
}
