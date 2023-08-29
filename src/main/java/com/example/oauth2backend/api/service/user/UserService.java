package com.example.oauth2backend.api.service.user;


import com.example.oauth2backend.api.domain.user.User;

import java.util.Optional;

public interface UserService {

	Optional<User> findByIdx(Long idx);

	Optional<User> findByEmail(String email);

	Boolean existsByIdx(Long idx);

	Boolean existsByEmail(String email);

}
