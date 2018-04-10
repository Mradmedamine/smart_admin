package org.smart.admin.model.json;

import java.util.List;

public class JsonDepartment {

	private String code;
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

}
