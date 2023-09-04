package com.example.oauth2backend.oauth2.domain;

import com.example.oauth2backend.com.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;


@Entity
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
@AllArgsConstructor
@Builder
@Getter
public class OAuth2User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="OAUTH2_USER_ID")
	private Long id;

	@Embedded
	private OAuth2Id oauth2Id;

	@Column(name = "OAUTH2_USER_EMAIL")
	private String email;

	@Column(name = "OAUTH2_USER_NICKNAME")
	private String nickname;

	@Column(name = "OAUTH2_USER_PROFILE_IMG")
	private String profileImageUrl;

}
