package com.example.login_demo.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserResponse(UUID userId,
                                 LocalDateTime createdAt) {
}
