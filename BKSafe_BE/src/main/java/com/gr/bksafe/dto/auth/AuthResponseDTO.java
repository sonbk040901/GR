package com.gr.bksafe.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 19:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthResponseDTO {
    String username;
    String email;
    String phone;
    String fullName;
    String avatar;
    String gender;
    String role;
}
