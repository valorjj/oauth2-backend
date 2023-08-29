package com.example.oauth2backend.oauth2.domain;


import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Authorization Code 를 사용하여 인가서버로부터 Access Token, Refresh Token 정보를 받아오면
 * 그 정보를 매칭시킬 DTO 입니다. 인가서버에서 받아오는 데이터는 불변이기 때문에 record 객체를 사용합니다.
 * record 는 java-14 부터 지원하기 때문에, java-8 을 사용하는 레거시 코드에는 사용할 수 없습니다.
 *
 *
 * @param tokenType
 * @param accessToken
 * @param idToken
 * @param accessTokenExpiration
 * @param refreshToken
 * @param refreshTokenExpiration
 * @param scope
 */
@JsonNaming(SnakeCaseStrategy.class)
public record OAuth2TokenDTO(
		String tokenType,
		String accessToken,
		String idToken,
		Long accessTokenExpiration,
		String refreshToken,
		Long refreshTokenExpiration,
		String scope
) {
}
