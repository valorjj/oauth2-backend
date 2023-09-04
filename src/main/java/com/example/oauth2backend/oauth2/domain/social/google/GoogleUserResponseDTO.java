package com.example.oauth2backend.oauth2.domain.social.google;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import static com.example.oauth2backend.oauth2.domain.OAuth2ProviderType.*;

@JsonNaming(SnakeCaseStrategy.class)
public record GoogleUserResponseDTO(
		String iss,
		String azp,
		String aud,
		String sub,
		String atHash,
		String hd,
		String email,
		String emailVerified,
		String iat,
		String exp,
		String nonce,
		String famailyName,
		String givenName,
		String locale,
		String name,
		String profile
) {

	public OAuth2User toEntity() {
		return OAuth2User.builder()
				.oauth2Id(new OAuth2Id(sub, GOOGLE))
				.email(email)
				.build();
	}
}
