package org.smart.admin.model.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document extends BaseEntity {

	private User user;
	private PhysicalFile physicalFile;

	@Embedded
	public PhysicalFile getPhysicalFile() {
		return physicalFile;
	}

	public void setPhysicalFile(PhysicalFile physicalFile) {
		this.physicalFile = physicalFile;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
