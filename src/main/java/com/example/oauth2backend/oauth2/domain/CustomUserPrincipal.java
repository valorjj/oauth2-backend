package com.example.oauth2backend.oauth2.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class CustomUserPrincipal implements UserDetails, OAuth2User, OidcUser {


	// 인가서버가 전송하는 사용자 식별값
	private final String userId;
	// 인가서버가 전송하는 사용자의 이메일
	private final String email;
	// 인가서버가 전송하는 사용자의 이름
	private final String username;
	// 인가서버가 전송하는 사용자의 권한
	private final Collection<? extends GrantedAuthority> authorities;
	// 인가서버가 전송하는 사용자의 특성
	private final Map<String, Object> attributes;

	public CustomUserPrincipal(String userId, String email, String username, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes) {
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.authorities = authorities;
		this.attributes = attributes;
	}

	public static CustomUserPrincipal createUserPrincipal(User user, Map<String, Object> attributes) {


		return null;
	}


	@Override
	public String getName() {
		return userId;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getClaims() {
		return null;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		return null;
	}

	@Override
	public OidcIdToken getIdToken() {
		return null;
	}
}
