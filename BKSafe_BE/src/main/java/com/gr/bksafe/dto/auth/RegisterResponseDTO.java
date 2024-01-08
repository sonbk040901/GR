package com.gr.bksafe.dto.auth;

import lombok.Builder;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:18
 */
@Builder
public record RegisterResponseDTO(String token) {
}
