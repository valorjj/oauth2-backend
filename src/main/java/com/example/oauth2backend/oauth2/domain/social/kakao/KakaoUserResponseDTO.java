package com.example.oauth2backend.oauth2.domain.social.kakao;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
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
				.oAuth2Id(new OAuth2Id(String.valueOf(id), KAKAO))
				.nickname(kakaoAccount().nickname)
				.profileImageUrl(kakaoAccount().picture)
				.build();
	}


	/**
	 * <a href="https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-oidc-user-info-response">카카오 개발자센터</a> 를 참조
	 * OpenID Connect 를 이용해 데이터를 받습니다.
	 */

	public record KakaoAccount(
			// 회원번호
			String sub,
			// 카카오계정 이름
			String name,
			// 서비스에서 쓰이는 사용자 닉네임
			// 기본값: 앱 연결 시 카카오계정 닉네임
			String nickname,
			// 서비스에서 쓰이는 사용자 썸네일 이미지 URL
			String picture,
			// 카카오계정 대표 이메일
			String email,
			// 카카오계정 이메일의 인증 및 유효 여부
			Boolean email_verified,
			// 카카오계정 성별
			String gender,
			// 카카오계정 생년월일
			String birthdate,
			// 카카오계정 전화번호
			String phone_number,
			// 카카오계정 전화번호 인증 여부
			Boolean phone_number_verified
	) {
	}


}
