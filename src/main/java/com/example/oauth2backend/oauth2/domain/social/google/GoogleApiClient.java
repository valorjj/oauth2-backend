package com.example.oauth2backend.oauth2.domain.social.google;

import com.example.oauth2backend.oauth2.domain.social.naver.NaverTokenDTO;
import com.example.oauth2backend.oauth2.domain.social.naver.NaverUserResponseDTO;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.NAVER_OAUTH2_AUTH_TOKEN_URL;
import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.NAVER_OAUTH2_USER_INFO;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public interface GoogleApiClient {

	@PostExchange(NAVER_OAUTH2_AUTH_TOKEN_URL)
	NaverTokenDTO fetchAuthToken(@RequestParam("parameters") MultiValueMap<String, String> parameters);

	@GetExchange(NAVER_OAUTH2_USER_INFO)
	NaverUserResponseDTO fetchUserInfo(@RequestHeader(name = AUTHORIZATION) String bearerToken);

}