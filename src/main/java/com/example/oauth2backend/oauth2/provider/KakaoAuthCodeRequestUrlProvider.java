package com.example.oauth2backend.oauth2.provider;

import com.example.oauth2backend.com.env.OAuth2KakaoProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

	private final OAuth2KakaoProperties kakaoProperties;

	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.KAKAO;
	}

	@Override
	public String provideRedirectUrl() {
		return UriComponentsBuilder
				.fromUriString(kakaoProperties.authorizationCodeUri())
				.queryParam("response_type", "code")
				.queryParam("client_id", kakaoProperties.restApiKey())
				.queryParam("redirect_uri", kakaoProperties.redirectUri())
				.queryParam("scope", String.join(" ", kakaoProperties.scope()))
				.toUriString();
	}
}
