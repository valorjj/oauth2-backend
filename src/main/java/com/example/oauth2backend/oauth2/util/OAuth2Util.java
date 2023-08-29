package com.example.oauth2backend.oauth2.util;

import java.util.List;
import java.util.stream.Collectors;

public class OAuth2Util {

	public static String createStringFromScope(List<String> scope) {
		return scope.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}

}
