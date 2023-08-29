package com.example.oauth2backend;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan("com.example.oauth2backend.com.env")
@Slf4j
@RequiredArgsConstructor
public class Oauth2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
		};
	}

}
