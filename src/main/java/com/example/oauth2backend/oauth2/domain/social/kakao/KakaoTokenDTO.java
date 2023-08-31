package com.example.oauth2backend.oauth2.domain.social.kakao;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


/**
 * Authorization Code 를 사용하여 인가서버로부터 Access Token, Refresh Token 정보를 받아오면
 * 그 정보를 매칭시킬 DTO 입니다. 인가서버에서 받아오는 데이터는 불변이기 때문에 record 객체를 사용합니다.
 * record 는 java-14 부터 지원하기 때문에, java-8 을 사용하는 레거시 코드에는 사용할 수 없습니다. <br/>
 * <a href="https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token">응답 파라미터 참고 링크</a>
 * {@code @JsonNaming(SnakeCaseStrategy.class)} 을 통해서 token_type 을 tokenType 에 매칭시킵니다.
 *
 * @param tokenType
 * @param accessToken
 * @param idToken
 * @param expiresIn
 * @param refreshToken
 * @param refreshTokenExpiresIn
 * @param scope
 */
@JsonNaming(SnakeCaseStrategy.class)
public record KakaoTokenDTO(
		String tokenType,
		String accessToken,
		String idToken,
		Integer expiresIn,
		String refreshToken,
		Integer refreshTokenExpiresIn,
		String scope
) {
}
