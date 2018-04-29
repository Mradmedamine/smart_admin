package org.smart.admin.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Userconnection")
public class UserConnection implements Serializable {

	private static final long serialVersionUID = -6991752510891411572L;

	private String userId;

	private String providerId;

	private String providerUserId;

	private int rank;

	private String displayName;

	private String profileUrl;

	private String imageUrl;

	private String accessToken;

	private String secret;

	private String refreshToken;

	private Long expireTime;

	@Id
	@Column(name = "Userid", length = 255, nullable = false)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Id
	@Column(name = "Providerid", length = 255, nullable = false)
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	@Id
	@Column(name = "Provideruserid", length = 255, nullable = false)
	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	@Column(name = "rank", length = 255, nullable = true)
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Column(name = "Displayname", length = 255, nullable = true)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "Profileurl", length = 512, nullable = true)
	public String getProfileUrl() {
		return profileUrl;
	}

	@Column(name = "Refreshtoken", length = 512, nullable = true)
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	@Column(name = "Imageurl", length = 512, nullable = true)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "Accesstoken", length = 512, nullable = true)
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "Secret", length = 512, nullable = true)
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Column(name = "Refreshtoken", length = 512, nullable = true)
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Column(name = "Expiretime", nullable = true)
	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

}