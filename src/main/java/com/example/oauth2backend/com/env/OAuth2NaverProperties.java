package com.example.oauth2backend.com.env;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth2.naver")
public record OAuth2NaverProperties(
		String authorizationCodeUri,
		String redirectUri,
		String clientId,
		String clientSecret,
		String[] scope,
		String state
) {
}
