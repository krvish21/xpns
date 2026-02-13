package com.krvish.xpns.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krvish.xpns.auth.jwt.JwtService;
import com.krvish.xpns.user.entity.UserEntity;
import com.krvish.xpns.user.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(String email, String password) {
        boolean userExists = this.userRepository.findByEmail(email).isPresent();
        if (userExists) {
            throw new IllegalArgumentException("Email already registered");
        }
        String hashedPassword = this.passwordEncoder.encode(password);

        UserEntity user = new UserEntity(email, hashedPassword);
        this.userRepository.save(user);
    }

    public String login(String email, String password) {
        UserEntity user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return this.jwtService.generateToken(user.getEmail());
    }
}
