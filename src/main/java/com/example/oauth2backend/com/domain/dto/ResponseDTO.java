package com.example.oauth2backend.com.domain.dto;

public record ResponseDTO<T>(Integer code, String message, T data) {

}
