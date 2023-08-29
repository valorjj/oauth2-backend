package com.example.oauth2backend.oauth2.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;


@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Table(name = "OAUTH2_USER_TB",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "OAUTH2_ID_UNIQUE",
						columnNames = {
								"OAUTH2_SERVER_ID",
								"OAUTH2_SERVER"
						}

				)

		}
)
public class OAuth2User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Embedded
	private OAuth2Id oAuth2Id;

	@Column(name = "OAUTH2_USER_EMAIL")
	private String email;

	@Column(name = "OAUTH2_USER_NICKNAME")
	private String nickname;

	@Column(name = "OAUTH2_USER_PROFILE_IMG")
	private String profileImageUrl;


	@Builder
	public OAuth2User(OAuth2Id oAuth2Id, String email, String nickname, String profileImageUrl) {
		this.oAuth2Id = oAuth2Id;
		this.email = email;
		this.nickname = nickname;
		this.profileImageUrl = profileImageUrl;
	}
}
