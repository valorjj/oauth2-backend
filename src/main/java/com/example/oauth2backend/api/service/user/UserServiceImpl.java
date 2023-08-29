package com.example.oauth2backend.api.service.user;

import com.example.oauth2backend.api.domain.user.User;
import com.example.oauth2backend.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public Optional<User> findByIdx(Long idx) {
		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return Optional.empty();
	}

	@Override
	public Boolean existsByIdx(Long idx) {
		return null;
	}

	@Override
	public Boolean existsByEmail(String email) {
		return null;
	}
}
