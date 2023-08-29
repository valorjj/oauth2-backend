package com.example.oauth2backend.com.aop;

import com.example.oauth2backend.com.domain.dto.ResponseDTO;
import com.example.oauth2backend.com.exception.CustomApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<?> customApiException(CustomApiException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(01, e.getMessage(), null));
	}


}
