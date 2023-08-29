package com.example.oauth2backend.oauth2.domain.client;


import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.exception.CustomOAuth2Exception;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 *
 *
 * */
@Component
public class OAuth2UserClientComposite {

	private final Map<OAuth2ProviderType, OAuth2UserClient> mapping;

	public OAuth2UserClientComposite(Set<OAuth2UserClient> clients) {
		mapping = clients.stream()
				.collect(toMap(
						OAuth2UserClient::oAuth2ProviderType,
						Function.identity()
				));
	}

	public OAuth2User fetch(OAuth2ProviderType oAuth2ProviderType, String authCode) {
		return getClient(oAuth2ProviderType).fetch(authCode);
	}

	private OAuth2UserClient getClient(OAuth2ProviderType oAuth2ProviderType) {
		return Optional.ofNullable(mapping.get(oAuth2ProviderType))
				.orElseThrow(() -> new CustomOAuth2Exception("지원하지 않는 소셜 로그인 타입입니다."));
	}


}
