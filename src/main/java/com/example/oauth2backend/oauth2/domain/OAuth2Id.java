package com.example.oauth2backend.oauth2.domain;

import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static lombok.AccessLevel.*;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class OAuth2Id {

	@Column(name = "OAUTH2_SERVER_ID", nullable = false)
	private String oauth2ServerId;

	@Enumerated(value = STRING)
	@Column(name = "OAUTH2_SERVER", nullable = false)
	private OAuth2ProviderType oauth2ProviderType;

}
