package com.example.oauth2backend.oauth2.domain.social.provider;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;

/**
 * 사용자의 요청에 따라 인가서버에 인가토큰을 받아오는 데 관여하는 메서드를 정의하는 인터페이스입니다.
 * 인증토큰은 엑세스토큰과 리프레시토큰을 요청하는 데 사용됩니다.
 * (response_type 을 code 로 지정한 경우 진행되는 authorization_code_flow 입니다.)
 */
public interface AuthCodeRequestUrlProvider {

	/**
	 * authorization_code 를 요청할 인가서버를 특정합니다.
	 * @return
	 */
	OAuth2ProviderType getOAuth2ProviderType();

	/**
	 * 인가서버에서 {@code authorization_code} 획득 후 이동할 url 을 반환합니다. <br/>
	 * 프론트서버에서 요청을 보내는 경우, 프론트서버의 도메인으로 이동시킵니다.
	 * @return
	 */
	String provideRedirectUrl();

}
