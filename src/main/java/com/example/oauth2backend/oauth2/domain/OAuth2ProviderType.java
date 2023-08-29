package com.example.oauth2backend.oauth2.domain;

import lombok.Getter;

import java.util.Locale;

import static java.util.Locale.*;

@Getter
public enum OAuth2ProviderType {

	GOOGLE,
	KAKAO,
	GITHUB,
	NAVER,
	LOCAL;

	public static OAuth2ProviderType fromProvidedName(String type) {
		return OAuth2ProviderType.valueOf(type.toUpperCase(ENGLISH));
	}

}
