package com.example.oauth2backend.oauth2.domain.social.provider;

import com.example.oauth2backend.com.env.OAuth2GoogleProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


/**
 * <a href="https://accounts.google.com/.well-known/openid-configuration">oauth2 configuration</a> 에서
 * 구글의 인가서버에 접근하는 API 주소를 확인할 수 있습니다.
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class GoogleAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

	private final OAuth2GoogleProperties googleProperties;

	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.GOOGLE;
	}

	@Override
	public String provideRedirectUrl() {
		return UriComponentsBuilder
				.fromUriString(googleProperties.authorizationCodeUri())
				.queryParam("response_type", "code")
				.queryParam("client_id", googleProperties.clientId())
				.queryParam("redirect_uri", googleProperties.redirectUri())
				.queryParam("scope", String.join(" ", googleProperties.scope()))
				.queryParam("state", "google-state-sample")
				.queryParam("access_type", "offline")
				.build()
				.toString();
	}
}
