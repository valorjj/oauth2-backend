package com.example.oauth2backend.oauth2.domain.social.kakao;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

import static com.example.oauth2backend.oauth2.domain.OAuth2ProviderType.*;

@JsonNaming(SnakeCaseStrategy.class)
public record KakaoUserResponseDTO(
		// 카카오 인증 서버에 등록된 사용자의 식별값
		Long id,

		// 사용자가 회원가입이 되어 있는지 여부
		Boolean hasSignedUp,
		// 최초 로그인을 시도한 시간
		LocalDateTime connectedAt,
		// 카카오 인증서버에서 전송한 사용자 정보
		// OpenID Connect 를 통한 정보를 전달받습니다.
		KakaoAccount kakaoAccount
) {

	/**
	 * KakaoUserResponseDTO 를 엔티티로 변환
	 */
	public OAuth2User toEntity() {
		return OAuth2User.builder()
				.oauth2Id(new OAuth2Id(String.valueOf(id), KAKAO))
				.nickname(kakaoAccount.profile.nickname)
				.profileImageUrl(kakaoAccount.profile.profileImageUrl)
				.build();
	}


	/**
	 * <a href="https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-oidc-user-info-response">카카오 개발자센터</a> 를 참조
	 * OpenID Connect 를 이용해 데이터를 받습니다.
	 */
	@JsonNaming(SnakeCaseStrategy.class)
	public record KakaoAccount(
			boolean profileNeedsAgreement,
			boolean profileNicknameNeedsAgreement,
			boolean profileImageNeedsAgreement,
			Profile profile,
			boolean nameNeedsAgreement,
			String name,
			boolean emailNeedsAgreement,
			boolean isEmailValid,
			boolean isEmailVerified,
			String email,
			boolean ageRangeNeedsAgreement,
			String ageRange,
			boolean birthyearNeedsAgreement,
			String birthyear,
			boolean birthdayNeedsAgreement,
			String birthday,
			String birthdayType,
			boolean genderNeedsAgreement,
			String gender,
			boolean phoneNumberNeedsAgreement,
			String phoneNumber,
			boolean ciNeedsAgreement,
			String ci,
			LocalDateTime ciAuthenticatedAt
	) {
	}

	@JsonNaming(SnakeCaseStrategy.class)
	public record Profile(
			String nickname,
			String thumbnailImageUrl,
			String profileImageUrl,
			boolean isDefaultImage
	) {
	}


}
