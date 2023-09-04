package com.example.oauth2backend.api.service.auth;

import com.example.oauth2backend.oauth2.domain.AuthCodeRequestUrlProviderComposite;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import com.example.oauth2backend.oauth2.domain.client.OAuth2UserClientComposite;
import com.example.oauth2backend.oauth2.repository.OAuth2UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

	private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;
	private final OAuth2UserClientComposite oAuth2UserClientComposite;
	private final OAuth2UserRepository oAuth2UserRepository;


	/**
	 * @param oAuth2ProviderType
	 * @return
	 */
	@Override
	public String getAuthCodeRequestUrl(OAuth2ProviderType oAuth2ProviderType) {
		return authCodeRequestUrlProviderComposite.provide(oAuth2ProviderType);
	}

	/**
	 * @param oAuth2ProviderType
	 * @param authorizationCode
	 * @return
	 */
	public Long oAuth2Login(OAuth2ProviderType oAuth2ProviderType, String authorizationCode) {
		// 1. 인가 서버로부터 회원 정보 획득
		OAuth2User oauth2User = oAuth2UserClientComposite.fetch(oAuth2ProviderType, authorizationCode);
		// 2. DB 등록 여부 확인
		OAuth2User savedOAuth2User = oAuth2UserRepository
				// 2.1. 이미 등록되어 있는 유저인 경우, DB 에서 데이터 획득
				.findByOauth2Id(oauth2User.getOauth2Id())
				// 2.2. 첫 로그인 시도인 경우, DB 에 저장
				.orElseGet(() -> oAuth2UserRepository.save(oauth2User));
		// 3. JWT 토큰 생성 시작

		// 3.1. access 토큰 생성

		// 3.2. refresh 토큰 생성

		// 4. 토큰을 쿠키에 저장

		// 4.1. 이미 존재한다면, 쿠키 삭제

		// 4.2. 존재하지 않으면 쿠키에 저장

		// 4.3. HttpServletResponse 에 담아서



		return savedOAuth2User.getId();
	}


}
