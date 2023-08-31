package com.example.oauth2backend.api.controller.auth;

import com.example.oauth2backend.api.service.auth.JwtServiceImpl;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/oauth2")
@RequiredArgsConstructor
public class JwtController {

	private final JwtServiceImpl jwtService;


	@SneakyThrows
	@GetMapping("/{oAuth2ProviderType}")
	public ResponseEntity<Void> redirectAuthCodeRequestUrl(
			@PathVariable OAuth2ProviderType oAuth2ProviderType,
			HttpServletResponse response
	) {
		String redirectUrl = jwtService.getAuthCodeRequestUrl(oAuth2ProviderType);
		log.info("[i] redirectUrl := [{}]", redirectUrl);
		response.sendRedirect(redirectUrl);
		return ResponseEntity.ok().build();
	}

	/**
	 * @param oAuth2ServerType 인가서버 종류
	 * @param code             인가코드
	 * @return
	 */
	@GetMapping("/login/{oAuth2ProviderType}")
	public ResponseEntity<Long> oAuth2Login(
			@PathVariable(name = "oAuth2ProviderType") OAuth2ProviderType oAuth2ServerType,
			@RequestParam(name = "code") String code
	) {
		Long loginOAuth2UserId = jwtService.oAuth2Login(oAuth2ServerType, code);
		return ResponseEntity.ok(loginOAuth2UserId);
	}

}
