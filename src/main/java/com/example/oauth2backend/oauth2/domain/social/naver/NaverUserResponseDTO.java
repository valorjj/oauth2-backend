package com.example.oauth2backend.oauth2.domain.social.naver;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import static com.example.oauth2backend.oauth2.domain.OAuth2ProviderType.*;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverUserResponseDTO(
		// API 호출 결과 코드
		String resultcode,
		// 호출 결과 메시지
		String message,
		Response response
) {

	public OAuth2User toEntity() {
		return OAuth2User.builder()
				.oauth2Id(new OAuth2Id(String.valueOf(response.id), NAVER))
				.nickname(response.nickname)
				.profileImageUrl(response.profileImage)
				.build();
	}


	@JsonNaming(SnakeCaseStrategy.class)
	public record Response(
			/*
			 * 동일인 식별 정보
			 * 네이버 아이디와 고유하게 발급되는 유니크한 일련번호 값
			 * 네이버 아이디값이 아닌 id 라는 어플리케이션 당 고유한 일련번호 값이다.
			 * */
			String id,
			/*
			 * 사용자 별명
			 * 별명이 설정되어 있지 않은 경우 id*** 형태로 리턴된다.
			 * */
			String nickname,
			// 사용자 이름
			String name,
			// 사용자 메일 주소
			String email,
			String gender,
			String age,
			String birthday,
			String profileImage,
			String birthyear,
			String mobile
	) {
	}

}
