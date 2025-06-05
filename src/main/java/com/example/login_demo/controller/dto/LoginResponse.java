package com.example.login_demo.controller.dto;

public record LoginResponse(String accessToken,
                            Long expiresIn) {
}
