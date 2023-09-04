package com.example.oauth2backend.oauth2.domain.social.kakao;

import com.example.oauth2backend.com.env.OAuth2KakaoProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.domain.client.OAuth2UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.*;

/**
 * auth code 를 사용해서 Kakao 인가 서버에서 access token, refresh token 을 받아옵니다.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoUserClient implements OAuth2UserClient {

	private final KakaoApiClient kakaoApiClient;
	private final OAuth2KakaoProperties kakaoProperties;


	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.KAKAO;
	}

	/**
	 * @param authorizationCode 엑세스, 리프레시 토큰을 인가서버로부터 받아오기 위한 인가 코드
	 * @return
	 */
	@Override
	public OAuth2User fetch(String authorizationCode) {
		KakaoTokenDTO oAuth2TokenDTO = kakaoApiClient.fetchAuthToken(tokenRequestParams(authorizationCode));
		return kakaoApiClient
				.fetchOAuth2User(TOKEN_PREFIX + oAuth2TokenDTO.accessToken())
				.toEntity();
	}

	/**
	 * <a href="https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token">kakao 공식 문서</a> 에서 설명하는 파라미터 값 그대로 적용시켜야 합니다.
	 *
	 * @param authorizationCode
	 * @return
	 */
	private MultiValueMap<String, String> tokenRequestParams(String authorizationCode) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", kakaoProperties.restApiKey());
		parameters.add("redirect_uri", kakaoProperties.redirectUri());
		parameters.add("code", authorizationCode);
		parameters.add("client_secret", kakaoProperties.clientSecret());
		return parameters;
	}


}
