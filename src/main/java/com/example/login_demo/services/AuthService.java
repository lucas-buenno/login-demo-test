package com.example.login_demo.services;

import com.example.login_demo.controller.dto.LoginRequest;
import com.example.login_demo.controller.dto.LoginResponse;
import com.example.login_demo.exception.LoginException;
import com.example.login_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Value("${jwt.expires-in}")
    private long expiresIn;

    public AuthService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, JwtService jwtService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }


    public LoginResponse login(LoginRequest request) {

        var user = userRepository.findByEmail(request.email())
                .orElseThrow(LoginException::new);


        boolean isPasswordValid = bCryptPasswordEncoder.matches(request.password(), user.getPassword());

        if (!isPasswordValid) {
            throw new LoginException();
        }

        String accessToken = jwtService.generateToken(user);

        return new LoginResponse(accessToken, expiresIn);
    }


}
