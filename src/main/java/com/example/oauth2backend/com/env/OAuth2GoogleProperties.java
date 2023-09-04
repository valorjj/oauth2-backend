package com.example.oauth2backend.com.env;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "oauth2.google")
public record OAuth2GoogleProperties(
		String redirectUri,
		String clientId,
		String clientSecret,
		String authorizationCodeUri,
		String[] scope
) {

}
