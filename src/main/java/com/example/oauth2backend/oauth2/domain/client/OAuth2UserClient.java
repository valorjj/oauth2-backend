package com.example.oauth2backend.oauth2.domain.client;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;

/**
 * {@code authorization_code} 를 통해 최종적으로 {@link OAuth2User} 를 생성합니다.
 * 인가서버의 타입, 사용자의 정보를 가져오는 메서드를 정의합니다.
 */
public interface OAuth2UserClient {

	/*
	 * 사용자 정보를 제공하는 인가서버를 특정합니다. (예: GOOGLE, KAKAO, GITHUB 등)
	 * */
	OAuth2ProviderType getOAuth2ProviderType();

	/**
	 * 인증 토큰을 이용해서 엑세스 토큰, 리프레시 토큰을 획득하는 메서드입니다.
	 *
	 * @param authorizationCode 엑세스, 리프레시 토큰을 인가서버로부터 받아오기 위한 인가 코드
	 * @return {@link OAuth2User}
	 */
	OAuth2User fetchUserInfo(String authorizationCode);

}
