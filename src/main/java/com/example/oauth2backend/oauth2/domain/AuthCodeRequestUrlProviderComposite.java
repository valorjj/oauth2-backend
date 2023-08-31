package com.example.oauth2backend.oauth2.domain;

import com.example.oauth2backend.com.exception.CustomApiException;
import com.example.oauth2backend.oauth2.provider.AuthCodeRequestUrlProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Component
@Slf4j
public class AuthCodeRequestUrlProviderComposite {

	private final Map<OAuth2ProviderType, AuthCodeRequestUrlProvider> mapping;

	/*
	 * 현재 AuthCodeRequestUrlProviderComposite 에 값을 넣어주는 곳이 없어서 null 값
	 * */
	public AuthCodeRequestUrlProviderComposite(Set<AuthCodeRequestUrlProvider> providers) {
		this.mapping = providers.stream().collect(toMap(AuthCodeRequestUrlProvider::getOAuth2ProviderType, identity()));
	}

	public String provide(OAuth2ProviderType oAuth2ProviderType) {
		return getProvider(oAuth2ProviderType).provideRedirectUrl();
	}

	public AuthCodeRequestUrlProvider getProvider(OAuth2ProviderType oAuth2ProviderType) {
		return Optional.ofNullable(mapping.get(oAuth2ProviderType))
				.orElseThrow(() -> new CustomApiException("지원하지 않는 소셜 로그인 타입입니다."));
	}

}
