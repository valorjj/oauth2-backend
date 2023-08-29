package com.example.oauth2backend.oauth2.domain;

import lombok.Data;

import java.util.Map;

@Data
public abstract class OAuth2UserInfo {

	protected Map<String, Object> attributes;

	public OAuth2UserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public abstract String getUserId();

	public abstract String getUsername();

	public abstract String getEmail();

	public abstract String getProfileImageUrl();


}
