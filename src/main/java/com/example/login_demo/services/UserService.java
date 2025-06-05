package com.example.login_demo.services;

import com.example.login_demo.controller.dto.CreateUserRequest;
import com.example.login_demo.controller.dto.CreateUserResponse;
import com.example.login_demo.entities.UserEntity;
import com.example.login_demo.exception.CreateUserException;
import com.example.login_demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public CreateUserResponse createUser(CreateUserRequest request) {

        log.debug("Creating user [emailMasked={}]", maskEmail(request.email()));
        boolean existsByEmail = userRepository.existsByEmail(request.email());

        if (existsByEmail) {
            log.info("Email already exists [emailMasked={}]", maskEmail(request.email()));
            throw new CreateUserException("Não foi possível criar o usuário");
        }

        UserEntity user = new UserEntity(
                request.email(),
                bCryptPasswordEncoder.encode(request.password())
        );

        var userCreated = userRepository.save(user);

        log.debug("User created {}", userCreated.getId());
        return new CreateUserResponse(userCreated.getId(), userCreated.getCreatedAt());
    }

    private String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "invalid";
        String[] parts = email.split("@");
        return parts[0].charAt(0) + "*****@" + parts[1];
    }

}
