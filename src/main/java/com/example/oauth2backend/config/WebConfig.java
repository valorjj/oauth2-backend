package com.example.oauth2backend.config;

import com.example.oauth2backend.jwt.filter.JwtAuthorizationFilter;
import com.example.oauth2backend.oauth2.domain.OAuth2ProviderTypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

	// Filter 에 포함되는 URL
	private static final String[] INCLUDE_PATHS = {
			"/api/*",
			"/oauth2/*",
			"/login/*"
	};

	@Bean
	public FilterRegistrationBean<JwtAuthorizationFilter> filterBean() {
		FilterRegistrationBean<JwtAuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtAuthorizationFilter());
		registrationBean.addUrlPatterns(INCLUDE_PATHS);
		registrationBean.setOrder(2);
		registrationBean.setName("jwtAuthorizationFilter");
		return registrationBean;
	}


	/**
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new OAuth2ProviderTypeConverter());
	}

	/**
	 * CORS 설정
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
				.allowedMethods(
						HttpMethod.GET.name(),
						HttpMethod.POST.name(),
						HttpMethod.PUT.name(),
						HttpMethod.DELETE.name(),
						HttpMethod.PATCH.name()
				)
				.allowedHeaders("*")
				.allowCredentials(true)
				.exposedHeaders("*");
	}

}
