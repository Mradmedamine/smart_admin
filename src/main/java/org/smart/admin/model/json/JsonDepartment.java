package org.smart.admin.model.json;

import java.util.List;

public class JsonDepartment {

	private String code;
	private String department;
	private String superficie;
	private String population;
	private String densite;
	private List<JsonCommune> communes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<JsonCommune> getCommunes() {
		return communes;
	}

	public void setCommunes(List<JsonCommune> communes) {
		this.communes = communes;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getDensite() {
		return densite;
	}

	public void setDensite(String densite) {
		this.densite = densite;
	}

	
}
