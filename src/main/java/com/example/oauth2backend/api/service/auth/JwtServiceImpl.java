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
		// 1.
		OAuth2User oAuth2User = oAuth2UserClientComposite.fetchUserInfo(oAuth2ProviderType, authorizationCode);
		// 2.
		OAuth2User savedOAuth2User = oAuth2UserRepository.findByOauth2Id(oAuth2User.getOauth2Id())
				.orElseGet(() -> oAuth2UserRepository.save(oAuth2User));
		// 3.
		return savedOAuth2User.getId();
	}
}
