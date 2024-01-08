package com.gr.bksafe.controller;

import com.gr.bksafe.dto.auth.*;
import com.gr.bksafe.dto.common.Response;
import com.gr.bksafe.service.AuthService;
import com.gr.bksafe.service.impl.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 17:06
 */
@RestController("/auth")
@RequestMapping("auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Response<?> register(@RequestBody RegisterRequestDTO register) {
        return Response.<RegisterResponseDTO>builder()
                .data(this.authService.register(register))
                .message("Đăng ký thành công")
                .success(true)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public Response<?> login(@RequestBody LoginRequestDTO login) {
        return Response.<LoginResponseDTO>builder()
                .data(this.authService.login(login))
                .message("Đăng nhập thành công")
                .success(true)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Response<?> getMe(UsernamePasswordAuthenticationToken principal) {
        var email = ((CustomUserDetails) principal.getPrincipal()).getUsername();
        return Response.<AuthResponseDTO>builder()
                .data(this.authService.getMe(email))
                .message("Đăng nhập thành công")
                .success(true)
                .build();
    }
}
