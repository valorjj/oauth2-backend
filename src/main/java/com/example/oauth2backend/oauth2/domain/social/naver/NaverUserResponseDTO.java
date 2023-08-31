package com.example.oauth2backend.oauth2.domain.social.naver;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import static com.example.oauth2backend.oauth2.domain.OAuth2ProviderType.*;

@JsonNaming(SnakeCaseStrategy.class)
public record NaverUserResponseDTO(
		String resultcode,
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
			String id,
			String nickname,
			String name,
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
