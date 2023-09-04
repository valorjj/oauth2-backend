package com.example.oauth2backend.oauth2.domain.social.google;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.example.oauth2backend.oauth2.contant.OAuth2Constant.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public interface GoogleApiClient {

	@PostExchange(value = GOOGLE_OAUTH2_AUTH_TOKEN_URL)
	GoogleTokenDTO fetchAuthToken(@RequestParam("parameters") MultiValueMap<String, String> parameters);

	@GetExchange(GOOGLE_OAUTH2_USER_INFO)
	GoogleUserResponseDTO fetch(@RequestHeader(name = AUTHORIZATION) String bearerToken);

}
