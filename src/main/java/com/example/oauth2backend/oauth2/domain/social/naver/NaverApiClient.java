package com.example.oauth2backend.oauth2.domain.social.naver;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.NAVER_OAUTH2_AUTH_TOKEN_URL;
import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.NAVER_OAUTH2_USER_INFO;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public interface NaverApiClient {

	@PostExchange(url = NAVER_OAUTH2_AUTH_TOKEN_URL)
	NaverTokenDTO fetchAuthToken(@RequestParam(name = "parameters") MultiValueMap<String, String> parameters);

	@GetExchange(url = NAVER_OAUTH2_USER_INFO)
	NaverUserResponseDTO fetchUserInfo(@RequestHeader(name = AUTHORIZATION) String bearerToken);

}
