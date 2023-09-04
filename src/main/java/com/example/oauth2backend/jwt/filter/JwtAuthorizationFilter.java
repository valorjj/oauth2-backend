package com.example.oauth2backend.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
		// 1. 엑세스 토큰 유효성 검사

		// 1-1. 엑세스 토큰 유효하면 컨트롤러 접근

		// 1-2. 엑세스 토큰 유효하지 않으면 리프레시 토큰으로 재발급


		doFilter(request, response, filterChain);
	}


}
