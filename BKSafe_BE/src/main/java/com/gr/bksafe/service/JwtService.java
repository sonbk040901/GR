package com.gr.bksafe.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 30/10/2023
 * @Time: 16:39
 */
public interface JwtService {
    boolean isValidToken(String token, UserDetails userDetails);
    Optional<String> extractUsername(String token);
    String generateToken(UserDetails userDetails);
}
