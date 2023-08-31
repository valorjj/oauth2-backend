package com.example.oauth2backend.oauth2.domain.social.naver;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverTokenDTO(
		String accessToken,
		String refreshToken,
		String tokenType,
		Integer expiresIn,
		String error,
		String errorDescription
) {
}
