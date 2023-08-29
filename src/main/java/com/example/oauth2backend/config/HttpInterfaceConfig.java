package com.example.oauth2backend.config;


import com.example.oauth2backend.oauth2.domain.social.kakao.KakaoApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * HTTP Interface Client 구현체를 Bean 으로 등록하는 설정 클래스이다.
 *
 */
@Configuration
public class HttpInterfaceConfig {

	@Bean
	public KakaoApiClient kakaoApiClient() {
		return createHttpInterface(KakaoApiClient.class);
	}

	private <T> T createHttpInterface(Class<T> clazz) {
		WebClient webClient = WebClient.create();
		return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build().createClient(clazz);
	}


}
