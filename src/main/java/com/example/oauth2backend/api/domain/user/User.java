package com.example.oauth2backend.api.domain.user;

import com.example.oauth2backend.com.domain.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "USER_TB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_IDX")
	private Long idx;

	@Column(name = "USER_ID")
	@Nullable
	private String userId;

	@Column(name = "USERNAME")
	@Nullable
	private String username;

	@Column(name = "PASSWORD")
	@Nullable
	private String password;

	@Column(name = "EMAIL")
	@Nullable
	private String email;

	@Column(name = "IMAGE_URL")
	@Nullable
	private String imageUrl;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	@Builder
	public User(String userId, String username, String password, String email, String imageUrl, RoleType roleType, ProviderType providerType) {
		this.userId = userId != null ? userId : "";
		this.username = username != null ? username : "";
		this.password = "NONE";
		this.email = email != null ? email : "NONE";
		this.imageUrl = imageUrl != null ? imageUrl : "";
		this.providerType = providerType != null ? providerType : ProviderType.LOCAL;
		this.roleType = roleType != null ? roleType : RoleType.USER;
	}
}
