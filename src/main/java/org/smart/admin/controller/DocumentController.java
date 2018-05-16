package org.smart.admin.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.common.util.SecurityUtils;
import org.smart.admin.model.entity.Document;
import org.smart.admin.model.entity.PhysicalFile;
import org.smart.admin.repository.DocumentRepository;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@GetMapping
	public String documentsList(Model model) {
		// model.addAttribute("documents",
		// documentRepository.findByUser_Username(SecurityUtils.findLoggedInUsername()));
		Document document = new Document();
		PhysicalFile file = new PhysicalFile();
		file.setFileName("Titre de Séjour");
		document.setPhysicalFile(file);
		model.addAttribute("documents", Collections.singleton(document));
		return "monDossier";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = { "multipart/mixed", MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveTemplateDocument(@RequestParam("physicalFile") MultipartFile file, Model model) {
		Document document = new Document();
		document.setPhysicalFile(createPhysicalFile(file));
		document.setUser(userService.findByUsername(SecurityUtils.findLoggedInUsername()));
		documentRepository.save(document);
		return StringUtils.EMPTY;
	}

	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteTemplateDocument(@PathVariable Long id, Model model) {
		documentRepository.delete(id);
		return StringUtils.EMPTY;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public void downloadTemplateDocument(@PathVariable Long id, HttpServletResponse response) {
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

}
