package com.example.oauth2backend.oauth2.domain.social.kakao;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.KAKAO_OAUTH2_AUTH_TOKEN_URL;
import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.KAKAO_OAUTH2_USER_INFO;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.*;


/**
 * HTTP 통신을 위해 {@code Rest Template} 이 아니라 {@code HTTP Interface Client} 를 사용합니다.
 */
public interface KakaoApiClient {

	/**
	 * 카카오 API 서버로부터 {@code AccessToken}, {@code RefreshToken} 을 발급받기 위해 {@code AuthorizationCode} 를 요청합니다.
	 *
	 * @param parameters
	 * @return
	 */
	@PostExchange(url = KAKAO_OAUTH2_AUTH_TOKEN_URL, contentType = APPLICATION_FORM_URLENCODED_VALUE)
	KakaoTokenDTO fetchAuthToken(@RequestParam(name = "parameters") MultiValueMap<String, String> parameters);

	/**
	 * <a href="https://kauth.kakao.com/.well-known/openid-configuration">카카오 openid endpoint 확인 링크</a> <br/>
	 * {@code AuthorizationCode} 를 이용해 {@code AccessToken}, {@code RefreshToken} 등 토큰 정보를 가져옵니다.
	 *
	 * @return
	 */
	@GetExchange(url = KAKAO_OAUTH2_USER_INFO)
	KakaoUserResponseDTO fetchOAuth2User(@RequestHeader(name = AUTHORIZATION) String bearerToken);

}
