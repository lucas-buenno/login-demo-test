package com.example.login_demo.controller;

import com.example.login_demo.controller.dto.LoginRequest;
import com.example.login_demo.controller.dto.LoginResponse;
import com.example.login_demo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/oauth/token")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        var response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}
