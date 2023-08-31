package com.example.oauth2backend.oauth2.provider;

import com.example.oauth2backend.com.env.OAuth2NaverProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class NaverAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {

	private final OAuth2NaverProperties naverProperties;

	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.NAVER;
	}

	@Override
	public String provideRedirectUrl() {
		return UriComponentsBuilder
				.fromUriString(naverProperties.authorizationCodeUri())
				.queryParam("response_type", "code")
				.queryParam("client_id", naverProperties.clientId())
				.queryParam("redirect_uri", naverProperties.redirectUri())
				.queryParam("state", naverProperties.state())
				.build().toString();
	}
}
