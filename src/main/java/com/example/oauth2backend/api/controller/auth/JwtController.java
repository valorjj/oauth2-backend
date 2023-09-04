package com.example.oauth2backend.api.controller.auth;

import com.example.oauth2backend.api.service.auth.JwtServiceImpl;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import com.example.oauth2backend.oauth2.util.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/oauth2")
@RequiredArgsConstructor
public class JwtController {

	private final JwtServiceImpl jwtService;


	/**
	 * @param oAuth2ProviderType
	 * @param request
	 * @param response
	 * @return
	 */
	@SneakyThrows
	@GetMapping("/{oAuth2ProviderType}")
	public ResponseEntity<?> redirectAuthCodeRequestUrl(
			@PathVariable OAuth2ProviderType oAuth2ProviderType,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		String redirectUrl = jwtService.getAuthCodeRequestUrl(oAuth2ProviderType);
		log.info("[i] redirectUrl := [{}]", redirectUrl);
		response.sendRedirect(redirectUrl);


		return ResponseEntity.ok().build();
	}

	/**
	 * @param oAuth2ServerType
	 * @param code
	 * @param response
	 * @return
	 */
	@GetMapping("/login/{oAuth2ProviderType}")
	public ResponseEntity<?> oAuth2Login(
			@PathVariable(name = "oAuth2ProviderType") OAuth2ProviderType oAuth2ServerType,
			@RequestParam(name = "code") String code,
			HttpServletResponse response
	) {
		Long loginOAuth2UserId = jwtService.oAuth2Login(oAuth2ServerType, code);

		ResponseCookie accessTokenCookie = ResponseCookie.from("cookie-name", "access-token-value")
				.path("/")
				.secure(true)
				.sameSite("None")
				.build();

		response.setHeader(HttpHeaders.SET_COOKIE, accessTokenCookie.toString());

		return ResponseEntity.ok().body("cookie");
	}

}


