package com.example.oauth2backend.oauth2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static lombok.AccessLevel.*;

/**
 * 인증 서버에서 받아오는 사용자의 식별값, 그리고 인증 서버 타입을 가진 클래스입니다.<br/>
 * (혹시나 모를) 식별자의 중복을 막기 위해서 해당 클래스가 @Embedded 되는 엔티티에 unique 제약이 존재합니다 -> {@link OAuth2User}
 */
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class OAuth2Id {

	@Column(name = "OAUTH2_SERVER_ID", nullable = false)
	@NotNull
	private String oauth2ServerId;

	@Enumerated(STRING)
	@Column(name = "OAUTH2_SERVER", nullable = false)
	@NotNull
	private OAuth2ProviderType oauth2ProviderType;

}
