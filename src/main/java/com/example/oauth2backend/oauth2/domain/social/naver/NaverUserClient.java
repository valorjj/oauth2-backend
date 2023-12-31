package com.example.oauth2backend.oauth2.domain.social.naver;

import com.example.oauth2backend.com.env.OAuth2NaverProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.domain.client.OAuth2UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.TOKEN_PREFIX;


@Component
@RequiredArgsConstructor
public class NaverUserClient implements OAuth2UserClient {

	private final NaverApiClient naverApiClient;
	private final OAuth2NaverProperties naverProperties;

	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.NAVER;
	}

	@Override
	public OAuth2User fetch(String authorizationCode) {
		NaverTokenDTO tokenDTO = naverApiClient
				.fetchAuthToken(tokenRequestParams(authorizationCode));
		return naverApiClient
				.fetchUserInfo(TOKEN_PREFIX + tokenDTO.accessToken())
				.toEntity();
	}

	private MultiValueMap<String, String> tokenRequestParams(String authorizationCode) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", naverProperties.clientId());
		parameters.add("client_secret", naverProperties.clientSecret());
		parameters.add("code", authorizationCode);
		// Base64 인코딩
		parameters.add("state", Base64.getEncoder().encodeToString(naverProperties.state().getBytes()));
		return parameters;
	}
}
