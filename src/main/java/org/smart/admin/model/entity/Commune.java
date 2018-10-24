package org.smart.admin.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "communes")
public class Commune extends BaseEntity {

	private String insee;
	private String text;
	private String address;

	public String getInsee() {
		return insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
