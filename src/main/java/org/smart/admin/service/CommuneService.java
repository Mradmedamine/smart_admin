package org.smart.admin.service;

import org.smart.admin.model.entity.Commune;

public interface CommuneService {

	void edit(Commune commune); 
	
	public Commune findByInsee(String insee);
	
}
