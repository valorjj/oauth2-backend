package com.example.oauth2backend.com.env;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;



@Data
@ConfigurationProperties(prefix = "oauth2.kakao")
public class OAuth2KakaoProperties {

	private String redirectUri;
	private String clientId;
	private String clientSecret;
	private String authorizationCodeUri;
	private String[] scope;

}
