package com.example.oauth2backend.oauth2.provider;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;

public class GithubAuthCodeRequestUrlProvider implements AuthCodeRequestUrlProvider {
	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return null;
	}

	@Override
	public String provideRedirectUrl() {
		return null;
	}
}
