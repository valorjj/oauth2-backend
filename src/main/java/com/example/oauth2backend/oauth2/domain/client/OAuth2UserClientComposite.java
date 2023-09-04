package com.example.oauth2backend.oauth2.domain.client;


import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.exception.CustomOAuth2Exception;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

/**
 * 여러 인가서버에서 받아오는 사용자 정보를 하나로 통합해서 사용합니다. {@code Map<OAuth2ProviderType, OAuth2UserClient> map} 객체로 관리합니다.
 */
@Component
public class OAuth2UserClientComposite {

	private final Map<OAuth2ProviderType, OAuth2UserClient> mapping;

	public OAuth2UserClientComposite(Set<OAuth2UserClient> clients) {
		this.mapping = clients
				.stream()
				.collect(toMap(
						OAuth2UserClient::getOAuth2ProviderType,
						identity()
				));
	}

	public OAuth2User fetch(OAuth2ProviderType oAuth2ProviderType, String authorizationCode) {
		return getClient(oAuth2ProviderType)
				.fetch(authorizationCode);
	}

	private OAuth2UserClient getClient(OAuth2ProviderType oAuth2ProviderType) {
		return Optional.ofNullable(mapping.get(oAuth2ProviderType))
				.orElseThrow(() -> new CustomOAuth2Exception("지원하지 않는 소셜 로그인 타입입니다."));
	}


}
