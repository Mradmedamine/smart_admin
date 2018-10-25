package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.entity.Commune;
import org.smart.admin.repository.CommuneRepository;
import org.smart.admin.service.CommuneService;
import org.smart.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommuneServiceImpl implements CommuneService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private CommuneRepository communeRepository;

	@Override
	public void edit(Commune commune) {
		communeRepository.save(commune);
	}

	public Commune findByInsee(String insee) {
		return communeRepository.findByInsee(insee).stream().findFirst().orElse(null);
	}

}
