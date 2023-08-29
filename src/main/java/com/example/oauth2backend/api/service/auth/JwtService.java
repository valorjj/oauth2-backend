package com.example.oauth2backend.api.service.auth;


import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;

public interface JwtService {

	String getAuthCodeRequestUrl(OAuth2ProviderType oAuth2ProviderType);


}
