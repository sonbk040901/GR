package com.gr.bksafe.service.impl;

import com.gr.bksafe.dto.auth.*;
import com.gr.bksafe.entity.User;
import com.gr.bksafe.handler.exception.UserAlreadyExistException;
import com.gr.bksafe.service.AuthService;
import com.gr.bksafe.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:14
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl extends BaseService implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO register) {
        var userExist = this.userDAO.findByEmail(register.email()).isPresent();
        if (userExist) throw new UserAlreadyExistException();
        var user = new User();
        BeanUtils.copyProperties(register, user);
        user.setPassword(passwordEncoder.encode(register.password()));
        user = this.userDAO.save(user);
        var token = this.jwtService.generateToken(new CustomUserDetails(user));
        return RegisterResponseDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO login) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.email(), login.password())
        );
        var user = this.userDAO.findByEmail(login.email()).orElseThrow();
        var token = this.jwtService.generateToken(new CustomUserDetails(user));
        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponseDTO getMe(String email) {
        var user = this.userDAO.findByEmail(email).orElseThrow();
        return AuthResponseDTO.builder()
                .avatar(user.getAvatar())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .username(user.getUsername())
                .gender(user.getGender().getName())
                .role(user.getRole().getName())
                .build();
    }
}
