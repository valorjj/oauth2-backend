package com.example.oauth2backend.oauth2.domain.client;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;

/**
 * {@code AuthorizationCode} 를 통해 최종적으로 {@link OAuth2User} 를 생성합니다.
 *
 */
public interface OAuth2UserClient {

	/*
	 *
	 * */
	OAuth2ProviderType oAuth2ProviderType();

	OAuth2User fetch(String authCode);

}
