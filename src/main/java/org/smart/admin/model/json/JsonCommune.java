package org.smart.admin.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonCommune {

	private CommuneData properties;
	private String type;

	public CommuneData getProperties() {
		return properties;
	}

	public void setProperties(CommuneData properties) {
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
