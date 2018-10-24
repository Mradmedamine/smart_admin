package org.smart.admin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "communes")
public class Commune extends BaseEntity {

	private String insee;
	private String text;
	private String address;
	private long nbEdit = 0;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInsee() {
		return insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	@Column(name="text", columnDefinition="LONGTEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getNbEdit() {
		return nbEdit;
	}

	public void setNbEdit(long nbEdit) {
		this.nbEdit = nbEdit;
	}

}