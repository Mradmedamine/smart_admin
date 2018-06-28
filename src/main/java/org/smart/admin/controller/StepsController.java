package org.smart.admin.controller;

import org.smart.admin.common.util.SecurityUtils;
import org.smart.admin.model.entity.UserCommuneComment;
import org.smart.admin.repository.DepartmentRepository;
import org.smart.admin.repository.UserCommuneCommentRepository;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/steps")
public class StepsController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCommuneCommentRepository userCommentRepository;

	@GetMapping("/{departmentCode}/{inseeCommune}")
	public String steps(@PathVariable String departmentCode, @PathVariable String inseeCommune, Model model) {
		model.addAttribute("commune", DepartmentRepository.getTownship(departmentCode, inseeCommune));
		model.addAttribute("comments", userCommentRepository.findByInseeCommune(inseeCommune));
		return "steps";
	}

	@ResponseBody
	@PostMapping("/{inseeCommune}/comment")
	public void comment(@PathVariable String inseeCommune, @RequestParam("comment") String comment, Model model) {
		UserCommuneComment userComment = new UserCommuneComment();
		userComment.setContent(comment);
		userComment.setInseeCommune(inseeCommune);
		userComment.setUser(userService.findByUsername(SecurityUtils.findLoggedInUsername()));
		userCommentRepository.save(userComment);
	}

}
