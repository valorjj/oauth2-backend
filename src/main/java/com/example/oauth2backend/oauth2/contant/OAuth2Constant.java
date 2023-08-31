package com.example.oauth2backend.oauth2.contant;

// final 을 사용해서 상속을 금지합니다.
public final class OAuth2Constant {

	// private 으로 객체 생성을 금지합니다.
	private OAuth2Constant() {

	}


	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";

	// kakao
	public static final String KAKAO_OAUTH2_AUTH_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
	public static final String KAKAO_OAUTH2_USER_INFO = "https://kapi.kakao.com/v2/user/me";


	// naver
	public static final String NAVER_OAUTH2_AUTH_TOKEN_URL = "https://nid.naver.com/oauth2.0/token";
	public static final String NAVER_OAUTH2_USER_INFO = "https://openapi.naver.com/v1/nid/me";

}
