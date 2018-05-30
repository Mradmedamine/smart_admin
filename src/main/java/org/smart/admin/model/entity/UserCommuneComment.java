package org.smart.admin.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_commune_comment")
public class UserCommuneComment extends BaseEntity {

	private String content;
	private String inseeCommune;
	private User user;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInseeCommune() {
		return inseeCommune;
	}

	public void setInseeCommune(String inseeCommune) {
		this.inseeCommune = inseeCommune;
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
