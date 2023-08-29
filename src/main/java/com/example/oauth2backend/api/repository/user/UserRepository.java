package com.example.oauth2backend.api.repository.user;

import com.example.oauth2backend.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByIdx(Long idx);

	Optional<User> findByEmail(String email);

	Boolean existsByEmail(String email);

	Boolean existsByIdx(Long idx);

}
