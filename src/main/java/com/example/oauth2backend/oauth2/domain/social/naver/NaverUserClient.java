package com.example.oauth2backend.oauth2.domain.social.naver;

import com.example.oauth2backend.com.env.OAuth2NaverProperties;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.domain.client.OAuth2UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
	public OAuth2User fetchUserInfo(String authorizationCode) {
		NaverTokenDTO tokenDTO = naverApiClient.fetchAuthToken(extractRequestParametersFromAuthToken(authorizationCode));
		return naverApiClient.fetchUserInfo(TOKEN_PREFIX + tokenDTO)
				.toEntity();
	}

	private MultiValueMap<String, String> extractRequestParametersFromAuthToken(String authorizationCode) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", naverProperties.clientId());
		parameters.add("redirect_uri", naverProperties.redirectUri());
		parameters.add("code", authorizationCode);
		parameters.add("client_secret", naverProperties.clientSecret());
		return parameters;
	}


}
