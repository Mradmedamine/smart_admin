package org.smart.admin.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonCommune {

	@JsonProperty("CODE_DEPT")
	private String codeDept;
	
	@JsonProperty("NOM_COMM")
	private String nomCommune;
	
	@JsonProperty("INSEE_COM")
	private String inseeCommune;
	
	private String income;

	public String getCodeDept() {
		return codeDept;
	}

	public void setCodeDept(String codeDept) {
		this.codeDept = codeDept;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getInseeCommune() {
		return inseeCommune;
	}

	public void setInseeCommune(String inseeCommune) {
		this.inseeCommune = inseeCommune;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

}
