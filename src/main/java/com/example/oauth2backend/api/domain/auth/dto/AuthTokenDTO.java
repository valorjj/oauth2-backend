package com.example.oauth2backend.api.domain.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class AuthTokenDTO {

	private String accessToken;
	private String refreshToken;


	@Builder
	public AuthTokenDTO(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}


}
