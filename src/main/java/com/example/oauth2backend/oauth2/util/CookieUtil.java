package com.example.oauth2backend.oauth2.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;
import java.util.Optional;

public class CookieUtil {

	private CookieUtil() {
	}


	public static Optional<Cookie> getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return Optional.of(cookie);
				}
			}
		}
		return Optional.empty();
	}

	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, Integer maxAge) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(maxAge);

		response.addCookie(cookie);
	}

	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookieName.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}

	public static String serialize(Object obj) {
		return Base64.getUrlEncoder()
				.encodeToString(SerializationUtils.serialize(obj));
	}

	public static <T> T deserialize(Cookie cookie, Class<T> cls) {
		return cls.cast(
				SerializationUtils.deserialize(
						Base64.getUrlDecoder().decode(cookie.getValue())
				)
		);
	}


}
