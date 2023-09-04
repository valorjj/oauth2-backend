package com.example.oauth2backend.jwt.domain;

import com.example.oauth2backend.com.domain.BaseEntity;
import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "REFRESH_TOKEN_TB")
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class RefreshToken extends BaseEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "REFRESH_TOKEN_ID")
	private Long id;

	@Column(name = "REFRESH_TOKEN")
	private String refreshToken;

	@Embedded
	private OAuth2Id oauth2Id;



}
