package com.example.oauth2backend.api.domain.auth;

import com.example.oauth2backend.api.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "ref_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	private String token;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_IDX")
	private User user;


	public void setUser(User user) {
		if (this.user != null) {
			this.user.getRefreshTokenList().remove(this);
		}

		this.user = user;
		if (user != null) {
			user.getRefreshTokenList().add(this);
		}
	}

	@Builder
	public RefreshToken(String token, User user) {
		this.token = token;
		this.user = user;
	}

	public RefreshToken(String token) {
		this.token = token;
	}
}
