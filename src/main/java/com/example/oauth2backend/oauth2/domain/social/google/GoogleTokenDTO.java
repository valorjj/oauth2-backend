package com.example.oauth2backend.oauth2.domain.social.google;


import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record GoogleTokenDTO(
		String accessToken,
		Integer expiresIn,
		String refreshToken,
		String scope,
		String tokenType,
		String idToken
) {
}
