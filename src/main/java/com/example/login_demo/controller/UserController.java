package com.example.login_demo.controller;

import com.example.login_demo.controller.dto.CreateUserRequest;
import com.example.login_demo.controller.dto.CreateUserResponse;
import com.example.login_demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request) {

        var userCreated = userService.createUser(request);

        return ResponseEntity.created(URI.create("/")).body(userCreated);
    }
}
