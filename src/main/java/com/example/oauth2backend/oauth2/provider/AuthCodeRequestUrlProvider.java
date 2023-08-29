package com.example.oauth2backend.oauth2.provider;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;

/**
 *
 *
 * AuthCode 를 발급할 URL 을 제공
 */
public interface AuthCodeRequestUrlProvider {

	OAuth2ProviderType getRegisteredProviderType();

	String provideRedirectUrl();

}
