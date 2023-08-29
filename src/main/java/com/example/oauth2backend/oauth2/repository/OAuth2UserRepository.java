package com.example.oauth2backend.oauth2.repository;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuth2UserRepository extends JpaRepository<OAuth2User, Long> {

	Optional<OAuth2User> findByOAuth2Id(OAuth2Id oAuth2Id);

}
