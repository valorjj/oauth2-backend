package com.example.oauth2backend.oauth2.repository;

import com.example.oauth2backend.oauth2.domain.OAuth2Id;
import com.example.oauth2backend.oauth2.domain.OAuth2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuth2UserRepository extends JpaRepository<OAuth2User, Long> {

	Optional<OAuth2User> findByOauth2Id(OAuth2Id oauth2Id);

}
