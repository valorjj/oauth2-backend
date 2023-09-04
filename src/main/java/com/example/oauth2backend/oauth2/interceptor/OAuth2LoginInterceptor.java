package com.example.oauth2backend.oauth2.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
public class OAuth2LoginInterceptor implements HandlerInterceptor {

	/**
	 * 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출된다. 이 부분에서 false 를 리턴하면, 컨트롤러로 요청이 전달되지 않는다.
	 *
	 * @param request  current HTTP request
	 * @param response current HTTP response
	 * @param handler  chosen handler to execute, for type and/or instance evaluation
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 클라이언트의 요청을 처리한 뒤에 호출된다. 컨트롤러에서 예외가 발생하면 실행되지 않는다.
	 *
	 * @param request      current HTTP request
	 * @param response     current HTTP response
	 * @param handler      the handler (or {@link HandlerMethod}) that started asynchronous
	 *                     execution, for type and/or instance examination
	 * @param modelAndView the {@code ModelAndView} that the handler returned
	 *                     (can also be {@code null})
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 클라이언트에게 응답을 보낸 후 실행된다.
	 *
	 * @param request  current HTTP request
	 * @param response current HTTP response
	 * @param handler  the handler (or {@link HandlerMethod}) that started asynchronous
	 *                 execution, for type and/or instance examination
	 * @param ex       any exception thrown on handler execution, if any; this does not
	 *                 include exceptions that have been handled through an exception resolver
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}


