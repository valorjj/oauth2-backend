package com.example.oauth2backend.api.controller.auth;

import com.example.oauth2backend.api.service.auth.JwtServiceImpl;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderType;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/oauth2")
@RequiredArgsConstructor
public class JwtController {

	private final JwtServiceImpl jwtService;


	@SneakyThrows
	@GetMapping("/{providerType}")
	ResponseEntity<?> redirectAuthCodeRequestUrl(
			@PathVariable("providerType") OAuth2ProviderType oAuth2ProviderType,
			HttpServletResponse response
	) {
		String redirectUrl = jwtService.getAuthCodeRequestUrl(oAuth2ProviderType);
		log.info("[+] redirectUrl := [{}]", redirectUrl);
		response.sendRedirect(redirectUrl);
		return ResponseEntity.ok().build();
	}

}
