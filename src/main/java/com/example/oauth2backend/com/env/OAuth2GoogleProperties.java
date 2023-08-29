package com.example.oauth2backend.com.env;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@Data
@ConfigurationProperties(prefix = "oauth2.google")
public class OAuth2GoogleProperties {

	private String redirectUri;
	private String clientId;
	private String clientSecret;
	private String authorizationCodeUri;
	private List<String> scope;

}
