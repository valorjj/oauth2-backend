package com.example.oauth2backend.oauth2.domain;

import jakarta.annotation.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;

public class OAuth2ProviderTypeConverter implements Converter<String, OAuth2ProviderType> {

	@Override
	public OAuth2ProviderType convert(@Nullable String source) {
		Assert.notNull(source, "OAuth 2.0 를 통한 소셜 로그인 시, 인가 서버가 null 일 수 없습니다.");
		return OAuth2ProviderType.fromProvidedName(source);
	}
}
