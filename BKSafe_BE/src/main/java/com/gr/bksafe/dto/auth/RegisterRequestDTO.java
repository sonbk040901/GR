package com.gr.bksafe.dto.auth;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:16
 */
public record RegisterRequestDTO(String username, String email, String fullName, String phone, String password) {
}
