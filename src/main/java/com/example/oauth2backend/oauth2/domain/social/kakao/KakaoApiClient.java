package com.example.oauth2backend.oauth2.domain.social.kakao;

import com.example.oauth2backend.oauth2.domain.OAuth2TokenDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.*;


/**
 * Rest Template 이 아니라 HTTP Interface Client 를 사용합니다.
 */
public interface KakaoApiClient {

	/**
	 * 카카오 API 서버로부터 {@code AccessToken}, {@code RefreshToken} 을 발급받기 위해 {@code AuthorizationCode} 를 요청합니다.
	 *
	 * @param params
	 * @return
	 */
	@PostExchange(url = "https://kauth.kakao.com/oauth2/token", contentType = APPLICATION_FORM_URLENCODED_VALUE)
	OAuth2TokenDTO fetchAuthToken(@RequestParam MultiValueMap<String, Object> params);

	/**
	 * <a href="https://kauth.kakao.com/.well-known/openid-configuration">카카오 openid endpoint 확인 링크</a>
	 * {@code AuthorizationCode} 를 이용해 {@code AccessToken}, {@code RefreshToken} 등 토큰 정보를 가져옵니다.
	 *
	 * @return
	 */
	@GetExchange(url = "https://kauth.kakao.com/oauth/token")
	KakaoUserResponseDTO fetchOAuth2User(@RequestHeader(name = AUTHORIZATION) String bearerToken);

}
