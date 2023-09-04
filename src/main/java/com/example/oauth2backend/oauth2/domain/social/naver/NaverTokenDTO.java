package com.example.oauth2backend.oauth2.domain.social.naver;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverTokenDTO(
		// expires_in 후 만료되는 토큰
		String accessToken,
		// 접근 토큰이 만료된 후 재발급 시 사용되는 갱신 토큰
		String refreshToken,
		// 접근 토큰의 타입으로 Bearer 와 MAC 두 가지를 지원
		String tokenType,
		// 접근 토큰의 유효 기간 (초 단위)
		Integer expiresIn,
		// 에러 코드
		String error,
		// 에러 메시지
		String errorDescription
) {
}
