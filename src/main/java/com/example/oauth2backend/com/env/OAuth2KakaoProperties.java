package com.example.oauth2backend.com.env;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth2.kakao")
public record OAuth2KakaoProperties(
		String redirectUri,
		String clientId,
		String restApiKey,
		String clientSecret,
		String authorizationCodeUri,
		String[] scope
) {
}
