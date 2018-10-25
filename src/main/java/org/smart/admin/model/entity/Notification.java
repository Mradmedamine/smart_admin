package org.smart.admin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {

	private String text;
	private User user;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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