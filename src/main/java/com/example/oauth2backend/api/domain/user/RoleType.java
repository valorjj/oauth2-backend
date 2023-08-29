package com.example.oauth2backend.api.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum RoleType {

	GUEST("ROLE_GUEST", "게스트 권한"),
	USER("ROLE_USER", "일반 유저 권한"),
	ADMIN("ROLE_ADMIN", "관리자 권한");

	private final String roleType;
	private final String displayName;


	public static RoleType of(String code) {
		return Arrays.stream(RoleType.values())
				.filter(role -> role.getRoleType().equalsIgnoreCase(code))
				.findAny()
				.orElse(GUEST);
	}
}
