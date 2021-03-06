package org.smart.admin.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.common.util.SecurityUtils;
import org.smart.admin.model.DocumentType;
import org.smart.admin.model.entity.Document;
import org.smart.admin.model.entity.PhysicalFile;
import org.smart.admin.repository.DocumentRepository;
import org.smart.admin.repository.NotificationRepository;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/monDossier")
@PreAuthorize("isAuthenticated()")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private NotificationRepository notificationRepo;

	@GetMapping
	public String documentsList(Model model) {
		model.addAttribute("documents", documentRepository.findByUser_Username(SecurityUtils.findLoggedInUsername()));
		return "monDossier";
	}

	@ResponseBody
	@PostMapping(value = "/{type}", consumes = { "multipart/mixed", MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveDocument(@PathVariable String type, @RequestParam("physicalFile") MultipartFile file,
			Model model) {
		Document document = new Document();
		document.setPhysicalFile(createPhysicalFile(file));
		document.setDocumentType(DocumentType.valueOf(type));
		document.setUser(userService.findByUsername(SecurityUtils.findLoggedInUsername()));
		documentRepository.save(document);
		return StringUtils.EMPTY;
	}

	@ResponseBody
	@DeleteMapping("/{id}")
	public String deleteDocument(@PathVariable Long id, Model model) {
		documentRepository.delete(id);
		return StringUtils.EMPTY;
	}

	@GetMapping("/{id}")
	public void downloadDocument(@PathVariable Long id, HttpServletResponse response) {
		Document document = documentRepository.findOne(id);
		PhysicalFile physicalFile = document.getPhysicalFile();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + physicalFile.getFileName() + "\"");
		try {
			OutputStream os = response.getOutputStream();
			ByteArrayInputStream in = new ByteArrayInputStream(physicalFile.getFileContent());
			IOUtils.copy(in, os);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error("error occured while downloading document id {}. Ex : {}", id, e.getMessage());
		}
	}

	private PhysicalFile createPhysicalFile(MultipartFile file) {
		try {
			if (file.getSize() > 0) {
				PhysicalFile physicalFile = new PhysicalFile();
				physicalFile.setFileName(file.getOriginalFilename());
				physicalFile.setFileContent(file.getBytes());
				return physicalFile;
			}
		} catch (IOException e) {
			// ignore
		}
		return null;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("notifs", notificationRepo.findByUser_Username(SecurityUtils.findLoggedInUsername()));
	}

}
