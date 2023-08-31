package com.example.oauth2backend.oauth2.provider;

import com.example.oauth2backend.com.env.OAuth2GoogleProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.util.OAuth2Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import static com.example.oauth2backend.oauth2.util.OAuth2Util.*;

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
				.fromUriString(googleProperties.getAuthorizationCodeUri())
				.queryParam("response_type", "code")
				.queryParam("client_id", googleProperties.getClientId())
				.queryParam("redirect_uri", googleProperties.getRedirectUri())
				.queryParam("scope", createStringFromScope(googleProperties.getScope()))
				.toUriString();
	}
}
