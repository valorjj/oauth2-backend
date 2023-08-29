package com.example.oauth2backend.api.service.auth;

import com.example.oauth2backend.oauth2.domain.AuthCodeRequestUrlProviderComposite;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

	private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;

	@Override
	public String getAuthCodeRequestUrl(OAuth2ProviderType oAuth2ProviderType) {
		return authCodeRequestUrlProviderComposite.provide(oAuth2ProviderType);
	}
}
