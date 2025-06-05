package com.example.login_demo.controller.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(@Email @Length(max = 100) String email,
                                @Length(min = 8, max = 24) String password) {
}
