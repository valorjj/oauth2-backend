package com.example.oauth2backend.oauth2.domain.social.google;

import com.example.oauth2backend.com.env.OAuth2GoogleProperties;
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
public class GoogleUserClient implements OAuth2UserClient {

	private final GoogleApiClient googleApiClient;
	private final OAuth2GoogleProperties googleProperties;

	@Override
	public OAuth2ProviderType getOAuth2ProviderType() {
		return OAuth2ProviderType.GOOGLE;
	}

	@Override
	public OAuth2User fetch(String authorizationCode) {
		GoogleTokenDTO tokenDTO = googleApiClient
				.fetchAuthToken(tokenRequestParams(authorizationCode));
		return googleApiClient
				.fetch(TOKEN_PREFIX + tokenDTO.accessToken())
				.toEntity();
	}

	private MultiValueMap<String, String> tokenRequestParams(String authorizationCode) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", googleProperties.clientId());
		parameters.add("client_secret", googleProperties.clientSecret());
		parameters.add("redirect_uri", googleProperties.redirectUri());
		parameters.add("code", authorizationCode);
		return parameters;
	}
}
