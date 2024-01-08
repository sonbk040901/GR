package com.gr.bksafe.service;

import com.gr.bksafe.dto.auth.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:14
 */
public interface AuthService {
    @Transactional
    RegisterResponseDTO register(RegisterRequestDTO register);
    @Transactional
    LoginResponseDTO login(LoginRequestDTO login);

    AuthResponseDTO getMe(String email);
}
