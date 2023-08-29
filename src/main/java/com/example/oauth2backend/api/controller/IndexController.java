package com.example.oauth2backend.api.controller;

import com.example.oauth2backend.com.domain.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {

	@GetMapping("/test")
	public ResponseEntity<?> test() {

		return ResponseEntity.ok().body(new ResponseDTO<>(200, "", null));
	}

}
